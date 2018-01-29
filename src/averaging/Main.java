package averaging;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		genetic();
//		control();
//		sampleSetup();
	}
	
	public static void genetic() {
		ArrayList<Simulation> s = new ArrayList<Simulation>();
		for (int i = 0; i < 100; i += 1) {
			s.add(new Simulation(5, 0, 0, 0.2));
		}
		
		double min = s.get(0).avg;
		for (int k = 0; k < 10000000; k += 1) {
			Collections.sort(s, new SimulationComparator());
			
			if (s.get(0).avg < min) {
				min = s.get(0).avg;
				System.out.println(k);
				System.out.println(s.get(0).toString());
			}
			
			for (int i = 0; i < 50; i += 1) {
				s.set(50 + i, new Simulation(s.get(i)));
			}
		}
	}
	
	public static void control() {
		Calculus c = new Calculus(0.01);
		Room r = new Room();
		r.signals.add(new SignalSource(20, 0, 0, 1, 440, 0));
		System.out.println(c.avgValue(r, 5, 0, 0, 0.2));
		
	}
	public static void sampleSetup() {
		Calculus c = new Calculus(0.01);
		Room r = new Room();
		r.signals.add(new SignalSource(20, 0, 0, 1, 440, 0));
		r.signals.add(new SignalSource(0, 5, 0, 0.279921, 440, 2.05951));
		r.signals.add(new SignalSource(0, -5, 0, 0.279921, 440, 2.05951));

		System.out.println(r.at(5, .1, 0).mod());
		System.out.println(c.avgValue(r, 5, 0, 0, 0.2));
	}
}

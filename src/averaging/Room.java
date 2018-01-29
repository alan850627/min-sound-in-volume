package averaging;

import java.util.ArrayList;

public class Room {
	public ArrayList<SignalSource> signals;

	public Room() {
		signals = new ArrayList<SignalSource>();
	}
	
	public Complex at(double x, double y, double z) {
		Complex out = new Complex(0, 0);
		for (SignalSource s : signals) {
			out = out.plus(s.at(x, y, z));
		}
		return out;
	}
	
	public String toString() {
		String out = "";
		for (int i = 0; i < signals.size(); i += 1) {
			out = out + "  Signal " + i + ": " + signals.get(i).toString() + "\n";
		}
		return out;
	}
}

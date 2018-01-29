package averaging;

public class Simulation {
	public final double RES = 0.01;

	public Room r;
	private Calculus c;
	public double avg;
	public double atx, aty, atz;
	public double s_length;

	public Simulation(double x, double y, double z, double sl) {
		c = new Calculus(RES);
		r = new Room();
		/* First signal is our noise source*/
		r.signals.add(new SignalSource(20, 0, 0, 1, 440, 0));

		r.signals.add(new SignalSource(0, 3, 0, Math.random() * 4 - 2, 440, Math.random() * 2 * Math.PI));
		r.signals.add(new SignalSource(0, 2, 0, Math.random() * 4 - 2, 440, Math.random() * 2 * Math.PI));
		r.signals.add(new SignalSource(0, 1, 0, Math.random() * 4 - 2, 440, Math.random() * 2 * Math.PI));
		r.signals.add(new SignalSource(0, 0, 0, Math.random() * 4 - 2, 440, Math.random() * 2 * Math.PI));
		r.signals.add(new SignalSource(0, -1, 0, Math.random() * 4 - 2, 440, Math.random() * 2 * Math.PI));
		r.signals.add(new SignalSource(0, -2, 0, Math.random() * 4 - 2, 440, Math.random() * 2 * Math.PI));
		r.signals.add(new SignalSource(0, -3, 0, Math.random() * 4 - 2, 440, Math.random() * 2 * Math.PI));

		atx = x;
		aty = y;
		atz = z;
		s_length = sl;

		avg = c.avgValue(r, atx, aty, atz, s_length);
	}

	public Simulation(Simulation s) {
		atx = s.atx;
		aty = s.aty;
		atz = s.atz;
		s_length = s.s_length;
		c = new Calculus(RES);
		r = new Room();

		/* keeping the first signal the same, since this is our noise source */
		r.signals.add(new SignalSource(s.r.signals.get(0).x, s.r.signals.get(0).y, s.r.signals.get(0).z,
				s.r.signals.get(0).amp, s.r.signals.get(0).freq, s.r.signals.get(0).phase));

		/* Random mutating multipliers */
		int mult = 1;
		if (Math.random() > 0.8) {
			mult = 10;
			if (Math.random() > 0.8) {
				mult = 100;
			}
		}

		/* Mutating the over signals */
		for (int i = 1; i < s.r.signals.size(); i += 1) {
			r.signals.add(new SignalSource(
					s.r.signals.get(i).x, 
					s.r.signals.get(i).y, 
					s.r.signals.get(i).z,
					s.r.signals.get(i).amp + Math.random() * mult * 0.01 - 0.005, 
					s.r.signals.get(i).freq,
					s.r.signals.get(i).phase + Math.random() * mult * 0.01 - 0.005));
		}

		this.avg = c.avgValue(r, atx, aty, atz, s_length);
	}

	private double toDB(double d) {
		return 20 * Math.log10(d / 0.00002);
	}

	public String toString() {
		String out = "-----\nRoom:\n" + r.toString();
		out = out + "\nAvg: " + avg;
		out = out + "\nOriginal dB: " + toDB(r.signals.get(0).at(atx, aty, atz).mod()) + "dB";
		out = out + "\nNew dB: " + toDB(avg) + "dB";
		out = out + "\n-----\n";
		return out;
	}

}

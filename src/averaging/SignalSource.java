package averaging;

public class SignalSource {
	public double amp;
	public double freq;
	public double phase;
	public double x;
	public double y;
	public double z;

	public SignalSource(double x, double y, double z, double a, double f,
			double p) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.amp = a;
		this.freq = f;
		this.phase = p;
	}

	/**
	 * Given a distance away from the source, returns the complex amplitude felt
	 * at that point.
	 * 
	 * @param r
	 * @return
	 */
	public Complex atDistance(double r) {
		double mod = amp / r;
		double arg = -2 * Math.PI * freq * r / 343 + phase;
		double re = mod * Math.cos(arg);
		double im = mod * Math.sin(arg);
		return new Complex(re, im);
	}

	/**
	 * Given (x, y, z), returns the complex amplitude felt at that point.
	 * 
	 * @param ox
	 * @param oy
	 * @param oz
	 * @return
	 */
	public Complex at(double ox, double oy, double oz) {
		double r = Math.sqrt((ox - x) * (ox - x) + (oy - y) * (oy - y)
				+ (oz - z) * (oz - z));
		return atDistance(r);
	}
	
	public String toString() {
		return amp + "exp(j*" + phase +") at ("+x+", "+y+", "+z+") at " + freq + "Hz";
	}
}

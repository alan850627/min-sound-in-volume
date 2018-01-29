package averaging;

public class Calculus {

	private double res;

	public Calculus(double res) {
		this.res = res;
	}

	/**
	 * Calculates the average value of cube of side length l centered at (x,y,z)
	 * in Room r.
	 * 
	 * @param r
	 * @param x
	 * @param y
	 * @param z
	 * @param l
	 * @return
	 */
	public double avgValue(Room r, double x, double y, double z, double l) {
		double out = 0;
		for (double i = 0; i < l; i += res) {
			for (double j = 0; j < l; j += res) {
				for (double k = 0; k < l; k += res) {
					out += r.at(x - l / 2 + i, y - l / 2 + j, z - l / 2 + k).mod()*res*res*res;
				}
			}
		}
		return out / (l * l * l);
	}
}

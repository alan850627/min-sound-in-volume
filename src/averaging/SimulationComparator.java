package averaging;

import java.util.Comparator;

public class SimulationComparator implements Comparator<Simulation> {

	@Override
	public int compare(Simulation s1, Simulation s2) {
		if (s1.avg > s2.avg) {
			return 1;
		} else if (s1.avg == s2.avg) {
			return 0;
		} else {
			return -1;
		}
	}

}

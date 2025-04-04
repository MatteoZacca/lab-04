package pcd.lab04.monitors.ex_barrier;

import java.util.ArrayList;
import java.util.List;

public class TestBarrier {

	public static void main(String[] args) {
		
		int nWorkers = 10;

		Barrier barrier = new BarrierImpl(nWorkers);
		
		/* this barrier is not working */
		// Barrier barrier = new FakeBarrier(nWorkers);
		
		List<Worker> workers = new ArrayList<Worker>();
		for (int i = 0; i < nWorkers; i++) {
			workers.add(new Worker("Worker-"+i, barrier));
		}

		/* for (Worker w : workers) {
			System.out.println(w.getName());
		} */

		for (Worker w: workers) {
			w.start();
		}
	}
}

package pcd.lab04.monitors.ex_latch;

public class ThreadA extends Thread {

	private Latch latch;
	
	public ThreadA(String name, Latch latch) {
		super(name);
		this.latch = latch;
	}
	
	public void run() {
		try {
			log("waiting opening.");
			latch.await(); // si sospende, in attesa che sia aperto il cancello, e il
			// cancello si apre quando al latch vengono segnalati il numero di eventi con
			// cui è stato costruito
			log("opened."); // 
		} catch (InterruptedException ex) {
			log("Interrupted!");
		}
	}
	
	private void log(String msg) {
		synchronized(System.out) {
			System.out.println("[ "+getName()+" ] "+msg);
		}
	}
	
	private void waitFor(long ms) throws InterruptedException{
		Thread.sleep(ms);
	}
}

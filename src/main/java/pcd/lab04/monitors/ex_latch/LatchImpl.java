package pcd.lab04.monitors.ex_latch;

public class LatchImpl implements Latch{
    private int count;

    public LatchImpl(int count) {
        this.count = count;
    }

    @Override
    public synchronized void await() throws InterruptedException {
        while (count > 0) {
            wait(); // Il thread A aspetta finchè count non diventa 0
        }
    }

    @Override
    public synchronized void countDown() {
        count--;
        if (count == 0) {
            notifyAll(); // Quando tutti i thread B hanno terminato, sblocca Thread A
        }
    }
}

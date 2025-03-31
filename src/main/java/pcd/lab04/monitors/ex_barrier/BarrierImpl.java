package pcd.lab04.monitors.ex_barrier;

public class BarrierImpl implements Barrier {

    private int nArrivedSoFar;
    private int nTotal;

    public BarrierImpl(int nTotal) {
        this.nTotal = nTotal;
        nArrivedSoFar = 0;
    }

    @Override
    public synchronized void hitAndWaitAll() throws InterruptedException {
        nArrivedSoFar++;
        if (nArrivedSoFar == nTotal) {
            notifyAll();
            // nArrivedSoFar = 0 ---> è il modo sbagliato se si vuole implementare una
            // cyclic barrier con questa riga di codice. nArrivedSoFar viene resettato
            // prima che possano ritestare la condizione di uscita
        } else {
            while (nArrivedSoFar < nTotal){
                wait();
            }
        }
    }
}

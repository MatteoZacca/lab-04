package pcd.lab04.liveness.deadlock_simplest;

public class TestDeadlockSimplest {
    public static void main(String[] args) {
        Resource res = new Resource();
        new ThreadA(res).start();
        new ThreadB(res).start();
    }

}

/* Mandando in esecuzione, è possibile notare che dopo alcune stampe, in modo non
deterministico il programma si blocca.

* */

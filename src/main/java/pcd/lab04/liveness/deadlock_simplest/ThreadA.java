package pcd.lab04.liveness.deadlock_simplest;

import pcd.lab04.liveness.accounts.BaseAgent;

public class ThreadA extends BaseAgent{

    private Resource res;

    public ThreadA(Resource res){
        this.res = res;
    }

    public void run(){
        while(true){
            // waitAbit()
            res.rightLeft();
        }
    }
}

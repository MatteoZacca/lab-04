package pcd.lab04.liveness.deadlock_simplest;

import pcd.lab04.liveness.accounts.BaseAgent;

public class ThreadB extends BaseAgent{

    private Resource res;

    public ThreadB(Resource res){
        this.res = res;
    }

    public void run(){
        while(true){
            // waitAbit()
            res.leftRight();
        }
    }

}
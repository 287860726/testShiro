package com.zhaocm.test.thread;

public class Demo1 extends Thread{

    @Override
    public void run() {
        System.out.println("extends Thread run()");
    }
}

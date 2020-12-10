package com.zhaocm.test.thread;


public class ThreadDemo1 {

    public static void main(String[] args) {
        int i =10;
        while(i > 0){
            Demo1 thread = new Demo1();
            thread.start();
            Thread thread1 = new Thread(new Demo2());
            thread1.start();
            i--;
        }
    }


}

package com.jy.base;


public class ThreadPriority extends Thread {

    private final int num;

    public ThreadPriority(int num, int priority) {
        this.num = num;
        this.setPriority(priority);
    }

    @Override
    public void run() {
        int a;
        for (int i = 0; i < 2000000000; i++) {
            a=i;
        }
        System.out.println(num + " : 끝");
    }
}

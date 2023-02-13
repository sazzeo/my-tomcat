package com.jy.base.server;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {

    private final List<Runnable> threads ;

    public ThreadPool(int threadNum) {
        this.threads = new ArrayList<>();
        for(int i= 0 ; i < threadNum ; i++) {
            threads.add(new HttpProcessor());
        }
    }
}

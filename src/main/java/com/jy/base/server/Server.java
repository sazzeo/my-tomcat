package com.jy.base.server;

public class Server {

    public void init() {
        new ThreadPool(10);
    }

    public static void main(String[] args) {
        new Server().init();
    }
}

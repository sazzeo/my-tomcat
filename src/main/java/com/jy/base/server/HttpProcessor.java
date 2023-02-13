package com.jy.base.server;

import com.jy.base.Connector;

import java.io.IOException;
import java.net.Socket;

public class HttpProcessor implements Runnable{

    private Socket connector ;

    @Override
    public void run() {
        Socket connector =  new Connector(8081).getConnector();
        this.connector = connector;

        System.out.println("서버실행했어유~^^");

        try {
            connector.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.jy.base;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Connector {
    private ServerSocket socket;

    public void makeSocket(int port) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("소켓을 여는데 실패했습니다.");
        }

        this.socket = serverSocket;
    }

    public Socket getConnector() {
        Socket accept = null;
        try {
            accept = this.socket.accept();
        } catch (IOException e) {
            System.out.println("소켓을 생성하는데 실패했습니다.");
        }
        return accept;
    }

    public ServerSocket getSocket() {
        return this.socket;
    }

    public void closeSocket() {
        try {
            this.socket.close();
        } catch (IOException e) {
            System.out.println("닫을 소켓이 없습니다.");
        }
    }

}

package com.jy.base;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketPractice {

    public void createSocket(int port) {
        try (ServerSocket socket = new ServerSocket(port, 1)) {

            System.out.println("연결대기");
            Socket connection = socket.accept();
            System.out.println("연결");
            InputStream inputStream = connection.getInputStream();
            OutputStream outputStream = connection.getOutputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            while (br.readLine() != null) {
                System.out.println(br.readLine());
            }

            Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
            writer.write("안녕??");
            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("===끝===");
        }
    }


}

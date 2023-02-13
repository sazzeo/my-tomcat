package com.jy.base.example;

import com.jy.base.Connector;
import com.jy.base.http.HttpRequest;
import com.jy.base.http.HttpResponse;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class Run {

    public static void main(String[] args)  {


        Connector connector = new Connector(8081);
        Socket connection = connector.getConnector();
        try(InputStream is = connection.getInputStream();
            OutputStream os = connection.getOutputStream()) {
            HttpRequest httpRequest = new HttpRequest(is);
            HttpResponse httpResponse = new HttpResponse(os);

            System.out.println(httpRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream() ));
//             final var outputStream = connection.getOutputStream()) {
//
//            String line ;
//            System.out.println("===============request==================");
//            while (!(line = bufferedReader.readLine()).equals("")) {
//                System.out.println(line);
//            }
//
//            System.out.println("=========================================");
//
//            final var responseBody = "Hello world!";
//
//            final var response = String.join("\r\n",
//                    "HTTP/1.1 200 OK ",
//                    "Content-Type: text/html;charset=utf-8 ",
//                    "Content-Length: " + responseBody.getBytes().length + " ",
//                    "",
//                    responseBody);
//
//            outputStream.write(response.getBytes());
//            outputStream.flush();
//        } catch (Exception e) {
//            System.out.println("에러");
//        }finally {
//        connector.closeSocket();
//            System.out.println("끝");
//        }


    }
}

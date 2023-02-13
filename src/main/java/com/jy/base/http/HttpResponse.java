package com.jy.base.http;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class HttpResponse {

    public HttpResponse(OutputStream ow) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(ow));
        BufferedWriter bw= bufferedWriter;
            String responseBody = "Hello world!";
            String response = String.join("\r\n",
                    "HTTP/1.1 200 OK ",
                    "Content-Type: text/html;charset=utf-8 ",
                    "Content-Length: " + responseBody.getBytes().length + " ",
                    "",
                    responseBody);

            bw.write(response);
            bw.flush();
    }
}

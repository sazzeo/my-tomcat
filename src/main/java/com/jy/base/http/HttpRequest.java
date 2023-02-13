package com.jy.base.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpRequest {

    private Map<String, String> attribute;

    private String method;
    private String path;
    private Map<String, String> parameter = new HashMap<>();


    public HttpRequest(InputStream inputStream) throws IOException {
        List<String> requestStringList = getRequestString(inputStream);
        String firstLine = getFirstLine(requestStringList);
        setDispatch(firstLine);
        setAttribute(requestStringList);
    }


    private List<String> getRequestString(InputStream inputStream) throws IOException {

            BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
            List<String> lines = new ArrayList<>();
            String line;
            while (!(line = bf.readLine()).equals("")) {
                lines.add(line);
            }
            return lines;
    }

    public void setAttribute(List<String> request) {
        Map<String, String> attribute = new HashMap<>();
        for(int i=1 ; i < request.size() ;i++) {
            String s = request.get(i);
            String[] split = s.split(":");
            attribute.put(split[0] , split[1].trim());
        }
        this.attribute = attribute;
    }

    public String getFirstLine(List<String> request) {
        if (request.size() < 1) throw new RuntimeException("유효하지 않은 요청입니다.");
        String firstLine = request.get(0);
        if (!firstLine.contains("HTTP")) throw new RuntimeException("유효하지 않은 요청입니다.");
        return firstLine;
    }

    public void setDispatch(String firstLine) {
        String[] firstLines = firstLine.split(" ");
        if (firstLines.length != 3) throw new RuntimeException("유효하지 않은 요청입니다.");
        setMethod(firstLines[0]);
        setPath(firstLines[1]);
        setParameter(firstLines[1]);
    }

    public void setMethod(String method) {
        for (Method value : Method.values()) {
            if (method.toUpperCase().equals(value.toString())) {
                this.method = method;
                return;
            }
        }

        throw new RuntimeException("유효하지 않은 요청입니다.");

    }

    public void setPath(String query) {
        int i = query.indexOf("?");
        if(i == -1) {
            this.path = query;
            return;
        }
        this.path = query.substring(0, i);
    }

    public void setParameter(String query) {
        int i = query.indexOf("?");
        if(i == -1) {
            return;
        }
        String params = query.substring(query.indexOf("?")+1);
        String[] split = params.split("&");
        for (String param : split) {
            String[] p = param.split("=");
            this.parameter.put(p[0], p.length < 2 ? null : p[1]);
        }
    }

    public Map<String, String> getRequestMap() {
        return this.attribute;
    }


    public Map<String, String> getAttribute() {
        return attribute;
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getParameter() {
        return parameter;
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "attribute=" + attribute +
                ", method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", parameter=" + parameter +
                '}';
    }
}

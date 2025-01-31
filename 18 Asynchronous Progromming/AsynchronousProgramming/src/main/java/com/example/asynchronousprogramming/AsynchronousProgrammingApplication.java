package com.example.asynchronousprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsynchronousProgrammingApplication {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(getWebpage);

        thread.start();
        System.out.printf("Thread Started %s%n", System.currentTimeMillis());
        thread.join();
        System.out.printf("Thread Finished %s%n", System.currentTimeMillis());
    }

    public static String getWebsite(URL url) throws IOException{
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

        return content;
    }

    static Runnable getWebpage = () -> {

        try {
            getWebsite(new URL("https://www.example.com"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };
}

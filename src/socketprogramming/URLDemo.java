package socketprogramming;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

//public class URLDemo {
//    public static void main(String[] args) throws IOException {
//        URL url = new URL("https://stackoverflow.com/questions/666864/first-packet-to-be-sent-when-starting-to-browse");
//        System.out.println(url.getProtocol());
//        System.out.println(url.getHost());
//        System.out.println(url.getPort());
//        System.out.println(url.getFile());
//        System.out.println(url.getPath());
//        System.out.println(url.getQuery());
//        System.out.println(url.getRef());
//        System.out.println(url.openConnection().getLastModified());
//
//        URLConnection connection = url.openConnection();
//        System.out.println(connection.getContentLength());
//        System.out.println(connection.getContentType());
//        System.out.println(connection.getContentEncoding());
//
//
//
//    }
//}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {
    public static void main(String[] args) {
        try {
            // Create a URL object
            URL url = new URL("https://www.google.com");

            // Open a connection to the URL
            URLConnection connection = url.openConnection();

            // Read data from the URL
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

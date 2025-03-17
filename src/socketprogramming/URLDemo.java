package socketprogramming;

//import javax.xml.crypto.Data;
import java.io.*;
import java.net.*;

public class URLDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://stackoverflow.com/questions/666864/first-packet-to-be-sent-when-starting-to-browse");
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
      System.out.println(url.getAuthority());
        System.out.println(url.getPort());
        System.out.println(url.getFile());
        System.out.println(url.getPath());
        System.out.println(url.getQuery());
        System.out.println(url.getRef());
        System.out.println(url.openConnection().getLastModified());

        URLConnection connection = url.openConnection();
        System.out.println(connection.getContentLength());
        System.out.println(connection.getContentType());
        System.out.println(connection.getContentEncoding());

      URL aURL = new URL("http://example.com:80/docs/books/tutorial"
        + "/index.html?name=networking#DOWNLOADING");

      System.out.println("protocol = " + aURL.getProtocol());
      System.out.println("authority = " + aURL.getAuthority());
      System.out.println("host = " + aURL.getHost());
      System.out.println("port = " + aURL.getPort());
      System.out.println("path = " + aURL.getPath());
      System.out.println("query = " + aURL.getQuery());
      System.out.println("filename = " + aURL.getFile());
      System.out.println("ref = " + aURL.getRef());


      URL oracle = new URL("http://www.stackoverflow.com/");
      BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

      String inputLine;
      while ((inputLine = in.readLine()) != null)
        System.out.println(inputLine);
      in.close();


    }
}

//public class URLDemo {
//    public static void main(String[] args) {
//        try {
//            // Create a URL object
//            URL url = new URL("https://www.google.com");
//
//            // Open a connection to the URL
//            URLConnection connection = url.openConnection();
//
//            // Read data from the URL
//            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//            reader.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}


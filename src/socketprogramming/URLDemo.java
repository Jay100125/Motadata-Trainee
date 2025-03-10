package socketprogramming;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://stackoverflow.com/questions/666864/first-packet-to-be-sent-when-starting-to-browse");
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
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

    }
}

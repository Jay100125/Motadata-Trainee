package socketprogramming.practice;

import java.io.IOException;
import java.net.*;

public class DatagramPracClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        String message = "Hello World";
        byte[] buf = message.getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        DatagramPacket dp = new DatagramPacket(buf, buf.length, address, 8080);

        ds.send(dp);

        byte[] buffer = new byte[1024];
        DatagramPacket response = new DatagramPacket(buffer, buffer.length);
        ds.receive(response);
        String reply = new String(response.getData(), 0, response.getLength());
        System.out.println("Received: " + reply);

        InetSocketAddress isa = new InetSocketAddress(address, 8080);
        System.out.println(isa);

    }
}

package socketprogramming.datagram;

import java.io.*;
import java.net.*;
import java.util.*;

public class QuoteClient {
    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.out.println("Usage: java QuoteClient <hostname>");
            return;
        }

        // get a datagram socket
        DatagramSocket socket = new DatagramSocket();

        // send request
        byte[] buf = new byte[256];
        InetAddress address = InetAddress.getByName("localhost");
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 8080);
        socket.send(packet);

        // get response
        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);

        // display response
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Quote of the Moment: " + received);

        socket.close();
    }
}
//
//https://www.youtube.com/watch?v=7L-SwV19bsw
//// https://www.slideshare.net/SubhadraSundarChakra/the-c10k-problem
//// https://www.youtube.com/watch?v=6y-vTMSuHmI&amp;t=2452s
//// https://www.youtube.com/watch?v=hCljQ30accU
package socketprogramming.practice;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramPracServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(8080);

        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
        datagramSocket.receive(datagramPacket);
        String message = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
        System.out.println(message);


        String reply = "Received your message";
        byte[] buffer2 = reply.getBytes();
        datagramPacket.setData(buffer2);
        datagramSocket.send(datagramPacket);

    }
}

package socketprogramming.practice;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramPracServer {
    public static void main(String[] args) throws Exception {
//        DatagramSocket datagramSocket = new DatagramSocket(8080);
//
//        byte[] buffer = new byte[1024];
//        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
//        datagramSocket.receive(datagramPacket);
//        String message = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
//        System.out.println(message);
//
//
//        String reply = "Received your message";
//        byte[] buffer2 = reply.getBytes();
//        datagramPacket.setData(buffer2);
//        datagramSocket.send(datagramPacket);

        InetAddress ip = InetAddress.getByName("192.168.103.96");
        DatagramSocket socket = new DatagramSocket(3000,ip);
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        String message = new String(packet.getData(),0,packet.getLength());
        System.out.println(message);
        socket.close();


    }
}

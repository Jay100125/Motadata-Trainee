//package socketprogramming.groupchatapp;
//
//import java.io.*;
//import java.net.*;
//import java.util.*;
//
//
//public class Client
//{
//
//    private static InetAddress host;
//
//    private static final int PORT = 1234;
//
//    private static DatagramSocket datagramSocket;
//
//    private static DatagramPacket inPacket, outPacket;
//
//    private static byte[] buffer;
//
//    public static void main (String[] args)
//    {
//
//        try
//        {
//            host = InetAddress.getByName("localhost");
//        }
//        catch ( Exception exception )
//        {
//            exception.printStackTrace();
//        }
//        accessServer();
//    }
//
//    private static void accessServer ()
//    {
//
//        try
//        {
//            datagramSocket = new DatagramSocket();
//
//            Scanner userEntry = new Scanner(System.in);
//
//            String message = "", response = "";
//
//            do
//            {
//                System.out.println("enter message :");
//                message = userEntry.nextLine();
//                if ( ! message.equals("bye") )
//                {
//                    outPacket = new DatagramPacket(message.getBytes(), message.length(), host, PORT);
//                    datagramSocket.send(outPacket);
//                    buffer = new byte[256];
//                    inPacket = new DatagramPacket(buffer, buffer.length);
//                    datagramSocket.receive(inPacket);
//                    response = new String(inPacket.getData(), 0, inPacket.getLength());
//                    System.out.println(" \n SERVER-->>" + response);
//                }
//            }
//            while ( ! message.equals("***CLOSE***") );
//        }
//        catch ( IOException ioEx )
//        {
//            ioEx.printStackTrace();
//        }
//
//        finally
//        {
//            System.out.println("\n closing connection.... ");
//            datagramSocket.close();
//        }
//    }
//
//}

package socketprogramming.groupchatapp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Client {
    public static void main(String[] args) throws Exception {


        InetAddress address = InetAddress.getByName("230.0.0.0");
        int port = 8080;

        MulticastSocket socket = new MulticastSocket();
        String msg = " hello world";
        byte[] buf = msg.getBytes();

        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);

        socket.send(packet);

        System.out.println("Sent message: " + msg);
        socket.close();
//        DatagramSocket socket = new DatagramSocket();
//
//        String message = "Hello World";
//        byte[] sendData = message.getBytes();
//        InetAddress ip = InetAddress.getByName("localhost");
//        DatagramPacket dp = new DatagramPacket(sendData,sendData.length,ip,8080);
//        socket.send(dp);
//
//        socket.close();
    }
}
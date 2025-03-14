//package socketprogramming.groupchatapp;
//
//import java.io.*;
//import java.net.*;
//
//public class server
//{
//    private static final int PORT = 1234;
//    private static DatagramSocket datagramSocket;
//    private static DatagramPacket inPacket, outPacket;
//    private static byte[] buffer;
//    public static void main (String[] args)
//    {
//        System.out.println("opening port \n");
//        try
//        {
//            datagramSocket = new DatagramSocket(PORT);
//        }
//        catch ( SocketException sockEx )
//        {
//            System.out.println("unable to open ");
//            System.exit(1);
//        }
//        handleClient();
//    }
//    private static void handleClient ()
//    {
//        try
//        {
//            String messageIn, messageOut;
//            int numMessages = 0;
//            InetAddress clientAddress = null;
//            int clientPort;
//            do
//            {
//                buffer = new byte[256];
//                inPacket = new DatagramPacket(buffer, buffer.length);
//                datagramSocket.receive(inPacket);
//                clientAddress = inPacket.getAddress();
//                clientPort = inPacket.getPort();
//                messageIn = new String(inPacket.getData(), 0, inPacket.getLength());
//                System.out.print(clientAddress);
//                System.out.print(" : ");
//                System.out.println(messageIn);
//                numMessages++;
//                messageOut = "message" + numMessages + ": " + messageIn;
//                outPacket = new DatagramPacket(messageOut.getBytes(), messageOut.length(), clientAddress, clientPort);
//                datagramSocket.send(outPacket);
//            }
//            while ( true );
//        }
//        catch ( IOException ioEx )
//        {
//            ioEx.printStackTrace();
//        }
//        finally
//        {
//            System.out.println("\n Closing connection.. ");
//            datagramSocket.close();
//        }
//    }
//
//}

package socketprogramming.groupchatapp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class server {
    public static void main(String[] args) throws IOException {

        InetAddress grp = InetAddress.getByName("230.0.0.0");
        int port = 8080;

        MulticastSocket ms = new MulticastSocket(port);
        ms.joinGroup(grp);

        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);

        ms.receive(dp);

        String msg = new String(dp.getData(), 0, dp.getLength());
        System.out.println(msg);

        ms.leaveGroup(grp);
        ms.close();


//        while (true) {
//            DatagramSocket socket = new DatagramSocket(8080);
//            byte[] buffer = new byte[1024];
//            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
//            socket.receive(packet);
//            String message = new String(packet.getData(), 0, packet.getLength());
//            System.out.println(message);
//            socket.close();
//        }
    }
}
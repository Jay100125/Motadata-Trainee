package socketprogramming.practice;

//import java.io.IOException;
//import java.net.*;
//
//public class DatagramPracClient {
//    public static void main(String[] args) throws IOException {
//        DatagramSocket ds = new DatagramSocket();
//
//        String message = "Hello World";
//        byte[] buf = message.getBytes();
//        InetAddress address = InetAddress.getByName("0.0.0.0");
//        DatagramPacket dp = new DatagramPacket(buf, buf.length, address, 3000);
////
//        ds.send(dp);
//        ds.close();
////        byte[] buffer = new byte[1024];
////        DatagramPacket response = new DatagramPacket(buffer, buffer.length);
////        ds.receive(response);
////        String reply = new String(response.getData(), 0, response.getLength());
////        System.out.println("Received: " + reply);
////
////        InetSocketAddress isa = new InetSocketAddress(address, 8080);
////        System.out.println(isa);
//
//    }
//}
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DatagramPracClient {
  public static void main(String[] args){

    server();

    client();

  }

  static void server(){

    try{
      ServerSocket ss=new ServerSocket(6666);
      Socket s=ss.accept();//establishes connection
      DataInputStream dis=new DataInputStream(s.getInputStream());
      String  str=(String)dis.readUTF();
      System.out.println("message= "+str);
      ss.close();
    }catch(Exception e){System.out.println(e);}

  }

  static void client(){

    try{
      Socket s=new Socket("localhost",6666);
      DataOutputStream dout=new DataOutputStream(s.getOutputStream());
      dout.writeUTF("Hello Server");
      dout.flush();
      dout.close();
      s.close();
    }catch(Exception e){System.out.println(e);}
  }
}

package socketprogramming;


import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class myserver{
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666);
        Socket s = ss.accept();
        s.setSoTimeout(300000);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        for(int i = 0; i < 5; i++)
        {
            System.out.println(dis.readUTF());

        }
        dis.close();

    }
}
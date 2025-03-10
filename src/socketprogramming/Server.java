package socketprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) {


        int port=8080;

        try {

            ServerSocket server=new ServerSocket(port);
            System.out.println("Server is runnig on:"+port);

                Socket client= server.accept();
                System.out.println("Client connected");

    while(true){
        BufferedReader data=new BufferedReader(new InputStreamReader(client.getInputStream()));
//        if(data.readLine()==null){break;}
        System.out.println("Client says "+ data.readLine());
    }




        }catch (Exception e)
        {
            System.out.println(e);
        }


    }
}

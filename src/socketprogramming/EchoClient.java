package socketprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) throws IOException {

        if(args.length != 2)
        {
            System.out.println("Usage: EchoClient <host> <port>");
            System.exit(1);
        }

        String host = args[0];
        int port = Integer.parseInt(args[1]);

        try(
            Socket echoSocket = new Socket(host, port);
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        ){
            String userInput;
            while((userInput = stdIn.readLine()) != null)
            {
                out.println(userInput);
                System.out.println(in.readLine());
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}

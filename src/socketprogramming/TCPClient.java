package socketprogramming;

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 12345);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.println("Connected to the server.");
            System.out.println("Server: " + reader.readLine());

            String userInput;
            while (true) {
                System.out.print("You: ");
                userInput = consoleReader.readLine();
                if (userInput.equalsIgnoreCase("exit")) break;

                writer.println(userInput);
                System.out.println("Server: " + reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

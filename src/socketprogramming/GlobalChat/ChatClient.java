package socketprogramming.GlobalChat;

import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 12345);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.println("Connected to the chat server.");
            System.out.println(reader.readLine()); // Read welcome message

            new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = reader.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    System.out.println("Server is down");
                    e.printStackTrace();
                }
            }).start();

            String userInput;
            while (true) {
                userInput = consoleReader.readLine();
                if (userInput.equalsIgnoreCase("exit")) {
                    writer.println("exit");
                    break;
                }
                writer.println(userInput);
            }
        } catch (IOException e) {
            System.out.println("Unable to connect to server. Server might be down.");
        }
    }
}

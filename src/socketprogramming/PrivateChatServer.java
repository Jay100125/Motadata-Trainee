package socketprogramming;
//////
//////import java.io.BufferedReader;
//////import java.io.IOException;
//////import java.io.InputStreamReader;
//////import java.io.PrintWriter;
//////import java.net.ServerSocket;
//////import java.net.Socket;
//////import java.util.concurrent.ConcurrentHashMap;
//////
//////public class PrivateChatServer {
//////    private static final int PORT = 8080;
//////    static final ConcurrentHashMap<String, ClientHandlerrrrr> clients = new ConcurrentHashMap<>();
//////
//////    public static void main(String[] args) throws IOException {
//////        System.out.println("Server started on port " + PORT);
//////
//////        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
//////            while(true)
//////            {
//////                Socket socket = serverSocket.accept();
//////                System.out.println("New Client connected from " + socket.getRemoteSocketAddress());
//////                new Thread(new ClientHandlerrrr(socket)).start();
//////            }
//////        }
//////         catch (IOException e) {
//////            e.printStackTrace();
//////         }
//////    }
//////
//////    static void registerClient(String identifier, ClientHandlerrrrr client) {
//////        clients.put(identifier, client);
//////    }
//////
//////    static void removeClient(String identifier) {
//////        clients.remove(identifier);
//////    }
//////
//////    static void sendMessage(String receiver, String sender, String message) {
//////        ClientHandlerrrrr client = clients.get(receiver);
//////        if(client != null)
//////        {
//////            client.sendMessage("[PrivateChatServer] " + sender + " " + message);
//////        }
//////        else
//////        {
//////            ClientHandlerrrrr senderClient = clients.get(sender);
//////            if(senderClient != null)
//////            {
//////                senderClient.sendMessage("User is not online");
//////            }
//////        }
//////    }
//////}
//////
//////class ClientHandlerrrrr implements Runnable
//////{
//////    private Socket socket;
//////    private PrintWriter writer;
//////    private BufferedReader reader;
//////    private String username;
//////
//////    public ClientHandlerrrrr(Socket socket)
//////    {
//////        this.socket = socket;
////////        this.identifier = socket.getRemoteSocketAddress().toString();
//////    }
//////
//////    @Override
//////    public void run() {
//////        try {
//////            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//////            writer = new PrintWriter(socket.getOutputStream(), true);
//////
//////            // Ask for username
//////            writer.println("Enter your username:");
//////            username = reader.readLine().trim();
//////
//////            if (username.isEmpty() || PrivateChatServer.clients.containsKey(username)) {
//////                writer.println("Username is empty or already taken. Connection closed.");
//////                socket.close();
//////                return;
//////            }
//////
//////            PrivateChatServer.registerClient(username, this);
//////            writer.println("Welcome, " + username + "! You can send messages using @recipient message");
//////
//////            String message;
//////            while ((message = reader.readLine()) != null) {
//////                if (message.equalsIgnoreCase("exit")) {
//////                    break;
//////                }
//////
//////                // Private message format: @username message
//////                if (message.startsWith("@")) {
//////                    int spaceIndex = message.indexOf(' ');
//////                    if (spaceIndex > 1) {
//////                        String recipient = message.substring(1, spaceIndex);
//////                        String privateMessage = message.substring(spaceIndex + 1);
//////                        PrivateChatServer.sendMessage(recipient, username, privateMessage);
//////                    } else {
//////                        writer.println("Invalid format. Use @username message");
//////                    }
//////                } else {
//////                    writer.println("Invalid message format. Use @username message");
//////                }
//////            }
//////        } catch (IOException e) {
//////            e.printStackTrace();
//////        } finally {
//////            PrivateChatServer.removeClient(username);
//////            System.out.println("Client " + username + " disconnected.");
//////            try {
//////                socket.close();
//////            } catch (IOException e) {
//////                e.printStackTrace();
//////            }
//////        }
//////    }
//////
//////    public void sendMessage(String message) {
//////        writer.println(message);
//////    }
//////}
//import java.io.*;
//import java.net.*;
//import java.util.*;
//import java.util.concurrent.*;
//
//public class PrivateChatServer {
//    private static final int PORT = 8080;
//    static final ConcurrentHashMap<String, ClientHandlerrrr> clients = new ConcurrentHashMap<>();
//    private static final int MAX_THREADS = 3; // Limit number of client threads
//    private static final ExecutorService threadPool = Executors.newFixedThreadPool(MAX_THREADS);
//
//    public static void main(String[] args) {
//        System.out.println("Server started on port " + PORT);
//
//        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
//            while (true) {
//                Socket clientSocket = serverSocket.accept();
//                threadPool.execute(new ClientHandlerrrr(clientSocket));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    static void registerClient(String username, ClientHandlerrrr client) {
//        clients.put(username, client);
//        System.out.println("Client " + username + " registered");
//    }
//
//    static void sendMessage(String recipient, String sender, String message) {
//        ClientHandlerrrr recipientClient = clients.get(recipient);
//        if (recipientClient != null) {
//            recipientClient.sendMessage("[Private] " + sender + ": " + message);
//        } else {
//            ClientHandlerrrr senderClient = clients.get(sender);
//            if (senderClient != null) {
//                senderClient.sendMessage("User '" + recipient + "' is not online.");
//            }
//        }
//    }
//
//    static void removeClient(String username) {
//        clients.remove(username);
//    }
//}
//
//class ClientHandlerrrr implements Runnable {
//    private static final int TIMEOUT = 15; // Inactivity timeout in seconds
//    private Socket socket;
//    private PrintWriter writer;
//    private BufferedReader reader;
//    private String username;
//    private ScheduledExecutorService timeoutScheduler = Executors.newSingleThreadScheduledExecutor();
//    private ScheduledFuture<?> timeoutTask;
//
//    public ClientHandlerrrr(Socket socket) {
//        this.socket = socket;
//    }
//
//    @Override
//    public void run() {
//        try {
//            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            writer = new PrintWriter(socket.getOutputStream(), true);
//
//            writer.println("Enter your username:");
//            username = reader.readLine().trim();
//
//            if (username.isEmpty() || PrivateChatServer.clients.containsKey(username)) {
//                writer.println("Username is empty or already taken. Connection closed.");
//                socket.close();
//                return;
//            }
//
//            PrivateChatServer.registerClient(username, this);
//            writer.println("Welcome, " + username + "! You can send messages using @recipient message");
//
//            resetTimeout();
//            String message;
//            while ((message = reader.readLine()) != null) {
//                resetTimeout();
//                if (message.equalsIgnoreCase("exit")) {
//                    break;
//                }
//
//                if (message.startsWith("@")) {
//                    int spaceIndex = message.indexOf(' ');
//                    if (spaceIndex > 1) {
//                        String recipient = message.substring(1, spaceIndex);
//                        String privateMessage = message.substring(spaceIndex + 1);
//                        PrivateChatServer.sendMessage(recipient, username, privateMessage);
//                    } else {
//                        writer.println("Invalid format. Use @username message");
//                    }
//                } else {
//                    writer.println("Invalid message format. Use @username message");
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            closeConnection();
//        }
//    }
//
//    private void resetTimeout() {
//        if (timeoutTask != null) {
//            timeoutTask.cancel(false);
//        }
//        timeoutTask = timeoutScheduler.schedule(this::closeConnection, TIMEOUT, TimeUnit.SECONDS);
//    }
//
//    private void closeConnection() {
//        try {
//            PrivateChatServer.removeClient(username);
//            if (socket != null && !socket.isClosed()) {
//                socket.close();
//            }
//            System.out.println("Client " + username + " disconnected due to inactivity.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void sendMessage(String message) {
//        writer.println(message);
//        resetTimeout();
//    }
//}


import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class PrivateChatServer {
    private static final int PORT = 8080;
    static final ConcurrentHashMap<String, ClientHandlerrr> clients = new ConcurrentHashMap<>();
    private static final ExecutorService clientPool = Executors.newFixedThreadPool(3);
    private static final ExecutorService messageListener = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        System.out.println("Server started on port " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            messageListener.execute(() -> listenForMessages());

            while (true) {
                Socket clientSocket = serverSocket.accept();
//                clientSocket.setReuseAddress();
                clientPool.execute(new ClientHandlerrr(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void listenForMessages() {
        while (true) {
            for (ClientHandlerrr client : clients.values()) {
                String message = client.readMessage();
                if (message != null) {
                    processMessage(client.getUsername(), message);
                }
            }
        }
    }

    private static void processMessage(String sender, String message) {
        if (message.startsWith("@")) {
            int spaceIndex = message.indexOf(' ');
            if (spaceIndex > 1) {
                String recipient = message.substring(1, spaceIndex);
                String actualMessage = message.substring(spaceIndex + 1);

                if (recipient.equalsIgnoreCase("all")) {
                    broadcastMessage(sender, actualMessage);
                } else {
                    sendMessage(recipient, sender, actualMessage);
                }
            } else {
                sendMessage(sender, "Server", "Invalid format. Use @username message or @all message");
            }
        } else {
            sendMessage(sender, "Server", "Invalid message format. Use @username message or @all message");
        }
    }

    private static void broadcastMessage(String sender, String message) {
        String formattedMessage = "[Broadcast] " + sender + ": " + message;
        for (ClientHandlerrr client : clients.values()) {
            if (!client.getUsername().equals(sender)) {
                client.sendMessage(formattedMessage);
            }
        }
        clients.get(sender).sendMessage("Your message was broadcast to all users: " + message);
    }

    private static void sendMessage(String recipient, String sender, String message) {
        ClientHandlerrr recipientClient = clients.get(recipient);
        if (recipientClient != null) {
            recipientClient.sendMessage("[Private] " + sender + ": " + message);
        } else {
            clients.get(sender).sendMessage("User '" + recipient + "' is not online.");
        }
    }

    static void registerClient(String username, ClientHandlerrr client) {
        clients.put(username, client);
        System.out.println("Client " + username + " registered.");
    }

    static void removeClient(String username) {
        clients.remove(username);
        System.out.println("Client " + username + " removed.");
    }
}


class ClientHandlerrr implements Runnable {
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;
    private String username;

    public ClientHandlerrr(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            writer.println("Enter your username:");
            username = reader.readLine().trim();

            if (username.isEmpty() || PrivateChatServer.clients.containsKey(username)) {
                writer.println("Username is empty or already taken. Try reconnecting.");
                socket.close();
                return;
            }

            PrivateChatServer.registerClient(username, this);
            writer.println("Welcome, " + username + "! Use @recipient message format.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    public String readMessage() {
        try {
            if (reader.ready()) {  // Non-blocking read
                return reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void sendMessage(String message) {
        writer.println(message);
    }
}

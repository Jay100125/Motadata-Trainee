//package socketprogramming.GlobalChat;
//
//import java.io.*;
//import java.net.*;
//import java.util.*;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class ChatServer {
//    private static final int PORT = 12345;
//    private static final int MAX_THREADS = 5; // Limit number of client threads
//    private static final ExecutorService threadPool = Executors.newFixedThreadPool(MAX_THREADS);
//
//    private static final Map<String, ClientHandler> clients = Collections.synchronizedMap(new HashMap<>());
//
//    public static void main(String[] args) {
//        System.out.println("Chat Server started...");
//
//        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
//            while (true) {
//                Socket clientSocket = serverSocket.accept();
////                new Thread(new ClientHandler(clientSocket)).start();
//                threadPool.execute(new ClientHandler(clientSocket));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    static void broadcast(String message, ClientHandler sender) {
//        synchronized (clients) {
//            for (ClientHandler client : clients.values()) {
//                if (client != sender) {
//                    client.sendMessage(message);
//                }
//            }
//        }
//    }
//
//    static boolean registerUsername(String username, ClientHandler client) {
//        synchronized (clients) {
//            if (clients.containsKey(username)) {
//                return false; // Username already taken
//            }
//            clients.put(username, client);
//            return true;
//        }
//    }
//
//    static void removeClient(String username) {
//        clients.remove(username);
//    }
//}
//
//class ClientHandler implements Runnable {
//    private Socket socket;
//    private PrintWriter writer;
//    private String username;
//
//    public ClientHandler(Socket socket) {
//        this.socket = socket;
//    }
//
//    @Override
//    public void run() {
//        try (
//                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
//        ) {
//            writer = new PrintWriter(socket.getOutputStream(), true);
//            writer.println("Enter your username: ");
//
//            while (true) {
//                username = reader.readLine();
//                if (username == null || username.trim().isEmpty() || username.contains(" ")) {
//                    writer.println("Invalid username. Please enter again (No spaces allowed).");
//                } else if (!ChatServer.registerUsername(username, this)) {
//                    writer.println("Username already taken. Try a different one.");
//                } else {
//                    break;
//                }
//            }
//
//            writer.println("Welcome, " + username + "! Type 'exit' to leave.");
//            System.out.println(username + " joined the chat.");
//            ChatServer.broadcast(username + " has joined the chat!", this);
//
//            String message;
//            while ((message = reader.readLine()) != null) {
//                if (message.equalsIgnoreCase("exit")) {
//                    break;
//                }
//                System.out.println(username + ": " + message);
//                ChatServer.broadcast(username + ": " + message, this);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            ChatServer.removeClient(username);
//            ChatServer.broadcast(username + " has left the chat.", this);
//            System.out.println(username + " disconnected.");
//            try {
//                socket.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void sendMessage(String message) {
//        writer.println(message);
//    }
//}

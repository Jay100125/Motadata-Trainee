package socketprogramming.groupchat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(1616);
            Server server = new Server(serverSocket);
            server.startServer();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void startServer() {
        try{
            while(! serverSocket.isClosed()) {
                System.out.println("Waiting for connection...");

                Socket socket = serverSocket.accept();
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                ClientHandler clientHandler = new ClientHandler(socket);
                new Thread(clientHandler).start();

            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

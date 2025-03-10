package socketprogramming;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CountDownLatch;
import org.glassfish.tyrus.server.Server;

// WebSocket Server Endpoint
@ServerEndpoint("/ws")
public class SimpleWebSocketServer {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Client connected: " + session.getId());
    }

    @OnMessage
    public String onMessage(String message) {
        System.out.println("Received: " + message);
        return "Echo: " + message; // Echo the message back
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Connection closed: " + session.getId());
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        throwable.printStackTrace();
    }

    public static void main(String[] args) {
        Server server = new Server("localhost", 8080, "/", null, SimpleWebSocketServer.class);
        try {
            server.start();
            System.out.println("WebSocket Server started on ws://localhost:8080/ws");
            new CountDownLatch(1).await(); // Keep server running
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

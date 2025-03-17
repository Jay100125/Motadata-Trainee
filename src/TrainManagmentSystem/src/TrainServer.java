package TrainManagmentSystem.src;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TrainServer {
  private static final int PORT = 8080;

  public static void main(String[] args) throws IOException {
    Train train = new Train("12345", "StationA", "StationB",
      LocalDate.of(2023, 10, 1), LocalDate.of(2023, 10, 1));
    ServerSocket serverSocket = new ServerSocket(PORT);
    System.out.println("Server started");
    System.out.println("Waiting for connection...");

    while(true){
      Socket socket = serverSocket.accept();
      new Thread(new ClientHandler(socket)).start();
    }

  }

  private static class ClientHandler implements Runnable{
    private Socket socket;

    public ClientHandler(Socket socket){
      this.socket = socket;

    }

    @Override
    public void run() {
      try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

        System.out.println("Client connected");
//        String request = in.readLine();
//        if(request == null)
//        {
//          return;
//        }
//
//        String response = processRequest(request);
//
      } catch (IOException e) {
        throw new RuntimeException(e);
      } ;

    }

//    private String processRequest(String request) {
//      String[] parts = request.split(" ");
//      String command = parts[0];
//
//      switch(command){
//        case "SEARCH":
//          String source = parts[1];
//          String destination = parts[2];
////          LocalDate
//      }
//    }
  }
}

package TrainManagmentSystem.src.server;

import TrainManagmentSystem.src.Booking;
import TrainManagmentSystem.src.Coach;
import TrainManagmentSystem.src.Train;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TrainServer
{
  private static List<Train> trains = new ArrayList<>();

  private static Map<String, Train> trainMap = new HashMap<>();

  private static Map<String, Booking> bookings = new ConcurrentHashMap<>();

  private static final int PORT = 8080;

  private static volatile boolean isShuttingDown = false;  // Create a flag to track if server is shutting down


  private static final long SAVE_INTERVAL_SECONDS = 300;   // Add periodic save timer (5 minutes)

  public static void main(String[] args) throws IOException
  {

    loadData(); // Load data from files at startup

    if (trains.isEmpty())
    {
      createSampleTrain(); // If no trains exist, create a sample train
    }

    setupAutoSave();     // Setup auto-save

    registerShutdownHook();  // Register shutdown hook

    ExecutorService executorService = Executors.newFixedThreadPool(5);

    ServerSocket serverSocket = new ServerSocket(PORT);

    System.out.println("Server started on port " + PORT);

    System.out.println("Waiting for connection...");

    try
    {
      while (!isShuttingDown)
      {
        try
        {
          Socket clientSocket = serverSocket.accept();

          System.out.println("New client connected: " + clientSocket.getInetAddress());

          executorService.submit(new RequestHandler(clientSocket, trains, trainMap, bookings));
        }
        catch (IOException e)
        {
          if (!isShuttingDown)
          {
            System.err.println("Error accepting client connection: " + e.getMessage());
          }
        }
      }
    }
    finally
    {
      isShuttingDown = true;

      System.out.println("Shutting down server...");

      executorService.shutdown();

      try
      {
        if (!executorService.awaitTermination(60, TimeUnit.SECONDS))
        {
          executorService.shutdownNow();
        }
      }
      catch (InterruptedException e)
      {
        executorService.shutdownNow();
      }
      serverSocket.close();

      saveData();

      System.out.println("Server shutdown complete");
    }
  }

  private static void createSampleTrain()
  {
    Train train = new Train("12345", "SA", "SB",
      LocalDate.of(2025, 10, 10), LocalDate.of(2025, 10, 11));

    train.getCoaches().add(new Coach("Sleeper", "C1", 5));

    train.getCoaches().add(new Coach("AC", "C2", 5));

    Train train2 = new Train("54321", "SA", "SB",
      LocalDate.of(2025, 10, 10), LocalDate.of(2025, 10, 11));

    train2.getCoaches().add(new Coach("Sleeper", "C1", 5));

    train2.getCoaches().add(new Coach("AC", "C2", 5));


    trains.add(train);

    trains.add(train2);

    trainMap.put(train.getTrainId(), train);

    trainMap.put(train2.getTrainId(), train2);

    System.out.println("Created sample train data");
  }

  private static void loadData()
  {
    System.out.println("Loading data from files...");

    TextDataPersistenceManager.loadAllData(trains, trainMap, bookings);
  }

  private static void saveData()
  {
    System.out.println("Saving data to files...");

    TextDataPersistenceManager.saveAllData(trains, bookings);
  }

  private static void setupAutoSave()
  {
    Thread autoSaveThread = new Thread(() -> {
      while (!isShuttingDown)
      {
        try
        {
          Thread.sleep(SAVE_INTERVAL_SECONDS * 1000);

          if (!isShuttingDown)
          {
            saveData();
          }
        }
        catch (InterruptedException e)
        {
          Thread.currentThread().interrupt();

          break;
        }
      }
    });

    autoSaveThread.setDaemon(true);

    autoSaveThread.start();

    System.out.println("Auto-save scheduled every " + SAVE_INTERVAL_SECONDS + " seconds");
  }

  private static void registerShutdownHook()
  {
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      System.out.println("Shutdown hook triggered - saving data");

      isShuttingDown = true;

      saveData();
    }));

    System.out.println("Shutdown hook registered");
  }
}

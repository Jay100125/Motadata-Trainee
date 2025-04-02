package TrainManagmentSystem.src.test.java;//package TrainManagmentSystem.src;
//
//import TrainManagmentSystem.src.server.TrainServer;
//import TrainManagmentSystem.src.Booking;
//import TrainManagmentSystem.src.Coach;
//import TrainManagmentSystem.src.Train;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.atomic.AtomicInteger;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//public class TrainSystemConcurrencyTest {
//  private static final Logger logger = LoggerFactory.getLogger(TrainSystemConcurrencyTest.class);
//  private static final int PORT = 8080;
//  private static final int NUM_USERS = 100;
//  private Thread serverThread;
//  private TrainServer trainServer;
//
//  @Before
//  public void setUp() throws IOException {
//    // Start the TrainServer in a separate thread
//    serverThread = new Thread(() -> {
//      try {
//        TrainServer.main(new String[]{});
//      } catch (IOException e) {
//        logger.error("Failed to start server: {}", e.getMessage(), e);
//      }
//    });
//    serverThread.start();
//
//    // Wait for the server to start (give it a moment to bind to the port)
//    try {
//      Thread.sleep(2000); // Adjust as needed
//    } catch (InterruptedException e) {
//      Thread.currentThread().interrupt();
//    }
//
//    // Initialize sample data (if not already present)
//    initializeSampleData();
//  }
//
//  @After
//  public void tearDown() throws InterruptedException {
//    // Shut down the server gracefully
//    serverThread.interrupt();
//    serverThread.join(2000); // Wait for server to stop
//  }
//
//  private void initializeSampleData() throws IOException {
//    // Add a sample train if not already present (simulating TrainServer's createSampleTrain)
//    try (Socket socket = new Socket("127.0.0.1", PORT);
//         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//         BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
//      // This assumes the server can handle an "INIT" command or similar; otherwise, rely on createSampleTrain
//      out.println("SEARCH SA SB 2025-10-10"); // Trigger sample data creation if empty
//      in.readLine(); // Consume response
//    }
//  }
//
//  @Test
//  public void testConcurrentSearch() throws InterruptedException {
//    logger.debug("Starting test for concurrent search");
//
//    ExecutorService executorService = Executors.newFixedThreadPool(NUM_USERS);
//    List<String> responses = new ArrayList<>();
//    AtomicInteger successfulSearches = new AtomicInteger(0);
//
//    for (int i = 0; i < NUM_USERS; i++) {
//      Runnable searchTask = () -> {
//        try (Socket socket = new Socket("127.0.0.1", PORT);
//             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
//          String command = "SEARCH SA SB 2025-10-10";
//          out.println(command);
//          StringBuilder response = new StringBuilder();
//          String line;
//          while ((line = in.readLine()) != null) {
//            response.append(line).append("\n");
//          }
//          synchronized (responses) {
//            responses.add(response.toString());
//          }
//          successfulSearches.incrementAndGet();
//        } catch (IOException e) {
//          logger.error("Search failed for user {}: {}", Thread.currentThread().getId(), e.getMessage());
//        }
//      };
//      executorService.submit(searchTask);
//    }
//
//    executorService.shutdown();
//    if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
//      logger.error("Search operations timed out");
//    }
//
//    // Verify results
//    assertEquals("Not all searches completed successfully", NUM_USERS, successfulSearches.get());
//    for (String response : responses) {
//      assertTrue("Search response should contain train info", response.contains("Train ID: 12345"));
//      assertTrue("Search response should contain coach info", response.contains("Coach ID: C1"));
//    }
//  }
//
//  @Test
//  public void testConcurrentBooking() throws InterruptedException {
//    logger.debug("Starting test for concurrent booking");
//
//    ExecutorService executorService = Executors.newFixedThreadPool(NUM_USERS);
//    List<String> pnrs = new ArrayList<>();
//    AtomicInteger successfulBookings = new AtomicInteger(0);
//
//    // Each user tries to book 1 seat on train "12345", coach "C1" (5 seats total initially)
//    for (int i = 0; i < NUM_USERS; i++) {
//      String userId = "user" + i;
//      Runnable bookTask = () -> {
//        try (Socket socket = new Socket("127.0.0.1", PORT);
//             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
//          String command = "BOOK " + userId + " 12345 C1 1";
//          out.println(command);
//          String response = in.readLine();
//          if (response != null && response.startsWith("Booking successful")) {
//            String pnr = response.split("PNR: ")[1].split(" ")[0];
//            synchronized (pnrs) {
//              pnrs.add(pnr);
//            }
//            successfulBookings.incrementAndGet();
//          }
//        } catch (IOException e) {
//          logger.error("Booking failed for user {}: {}", userId, e.getMessage());
//        }
//      };
//      executorService.submit(bookTask);
//    }
//
//    executorService.shutdown();
//    if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
//      logger.error("Booking operations timed out");
//    }
//
//    // Verify results: Only 5 seats available, so max 5 bookings should succeed
//    assertTrue("Too many bookings succeeded (max 5 seats)", successfulBookings.get() <= 5);
//    assertEquals("Number of PNRs should match successful bookings", successfulBookings.get(), pnrs.size());
//
//    // Check remaining seats (should be 0)
//    try (Socket socket = new Socket("127.0.0.1", PORT);
//         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//         BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
//      out.println("SEARCH SA SB 2025-10-10");
//      StringBuilder response = new StringBuilder();
//      String line;
//      while ((line = in.readLine()) != null) {
//        response.append(line).append("\n");
//      }
//      assertTrue("All seats should be booked", response.toString().contains("Available Seats: 0"));
//    } catch (IOException e) {
//      logger.error("Failed to verify remaining seats: {}", e.getMessage());
//    }
//  }
//
//  @Test
//  public void testMixedOperations() throws InterruptedException {
//    logger.debug("Starting test for mixed search and booking");
//
//    ExecutorService executorService = Executors.newFixedThreadPool(NUM_USERS);
//    AtomicInteger successfulSearches = new AtomicInteger(0);
//    AtomicInteger successfulBookings = new AtomicInteger(0);
//
//    for (int i = 0; i < NUM_USERS; i++) {
//      String userId = "user" + i;
//      int finalI = i;
//      Runnable mixedTask = () -> {
//        try (Socket socket = new Socket("127.0.0.1", PORT);
//             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
//          if (finalI % 2 == 0) { // Even users search
//            out.println("SEARCH SA SB 2025-10-10");
//            String response = in.readLine();
//            if (response != null && response.contains("Train ID: 12345")) {
//              successfulSearches.incrementAndGet();
//            }
//          } else { // Odd users book
//            out.println("BOOK " + userId + " 12345 C1 1");
//            String response = in.readLine();
//            if (response != null && response.startsWith("Booking successful")) {
//              successfulBookings.incrementAndGet();
//            }
//          }
//        } catch (IOException e) {
//          logger.error("Mixed operation failed for user {}: {}", userId, e.getMessage());
//        }
//      };
//      executorService.submit(mixedTask);
//    }
//
//    executorService.shutdown();
//    if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
//      logger.error("Mixed operations timed out");
//    }
//
//    // Verify results
//    assertEquals("Half the users should search successfully", NUM_USERS / 2, successfulSearches.get());
//    assertTrue("Bookings should be limited by available seats (max 5)", successfulBookings.get() <= 5);
//  }
//}
import TrainManagmentSystem.src.server.RequestHandler;
import TrainManagmentSystem.src.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TrainSystemConcurrencyTest {
  private static final Logger logger = LoggerFactory.getLogger(TrainSystemConcurrencyTest.class);
  private List<Train> trains;
  private Map<String, Train> trainMap;
  private Map<String, Booking> bookings;
  private RequestHandler requestHandler;

  @BeforeEach
  public void setUp() {
    // Initialize test data
    trains = new ArrayList<>();
    trainMap = new HashMap<>();
    bookings = new ConcurrentHashMap<>();

    // Create test train with 5 seats
    Train testTrain = new Train("TEST1", "London", "Paris",
      LocalDate.now(), LocalDate.now().plusDays(1));
    testTrain.getCoaches().add(new Coach("AC", "C1", 5));
    trains.add(testTrain);
    trainMap.put("TEST1", testTrain);

    // Initialize request handler with test data
    requestHandler = new RequestHandler(null, trains, trainMap, bookings);
  }

  @Test
  public void testConcurrentBooking() throws InterruptedException {
    final int THREAD_COUNT = 100;
    final AtomicInteger successCount = new AtomicInteger(0);
    final AtomicInteger failureCount = new AtomicInteger(0);

    ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

    // Create 100 booking requests
    for (int i = 0; i < THREAD_COUNT; i++) {
      executor.execute(() -> {
        String response = requestHandler.handleBooking(
          new String[]{"BOOK", "user1", "TEST1", "C1", "1"}
        );
        if (response.contains("Booking successful")) {
          successCount.incrementAndGet();
        } else {
          failureCount.incrementAndGet();
        }
      });
    }

    executor.shutdown();
    executor.awaitTermination(10, TimeUnit.SECONDS);

    logger.info("Successful bookings: {}, Failed bookings: {}",
      successCount.get(), failureCount.get());

    // Verify only 5 seats were booked
    Coach coach = trainMap.get("TEST1").getCoaches().get(0);
    long bookedSeats = coach.getSeatBookings().values()
      .stream()
      .filter(Objects::nonNull)
      .count();

    assertEquals(5, successCount.get());
    assertEquals(95, failureCount.get());
    assertEquals(5, bookedSeats);
  }

  @Test
  public void testConcurrentSearchAndBooking() throws InterruptedException {
    final int THREAD_COUNT = 100;
    final AtomicInteger searchSuccess = new AtomicInteger(0);
    final AtomicInteger bookingSuccess = new AtomicInteger(0);

    ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

    // 50% search requests, 50% booking requests
    for (int i = 0; i < THREAD_COUNT; i++) {
      if (i % 2 == 0) {
        // Search request
        executor.execute(() -> {
          String response = requestHandler.handleSearch(
            new String[]{"SEARCH", "London", "Paris", LocalDate.now().toString()}
          );
          if (!response.contains("No trains available")) {
            searchSuccess.incrementAndGet();
          }
        });
      } else {
        // Booking request
        executor.execute(() -> {
          String response = requestHandler.handleBooking(
            new String[]{"BOOK", "user1", "TEST1", "C1", "1"}
          );
          if (response.contains("Booking successful")) {
            bookingSuccess.incrementAndGet();
          }
        });
      }
    }

    executor.shutdown();
    executor.awaitTermination(10, TimeUnit.SECONDS);

    logger.info("Successful searches: {}, Successful bookings: {}",
      searchSuccess.get(), bookingSuccess.get());

    // Verify data consistency
    Coach coach = trainMap.get("TEST1").getCoaches().get(0);
    long availableSeats = coach.getSeatBookings().values()
      .stream()
      .filter(Objects::isNull)
      .count();

//    assertTrue(searchSuccess.get() > 0);
    assertEquals(5 - bookingSuccess.get(), availableSeats);
  }
}

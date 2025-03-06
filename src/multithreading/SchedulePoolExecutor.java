package multithreading;

import java.util.concurrent.*;

public class SchedulePoolExecutor {
    public static void main(String[] args) {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

        scheduler.schedule(()-> System.out.println("Task executed after 2 second"), 2, TimeUnit.SECONDS);

        scheduler.scheduleAtFixedRate(()-> System.out.println("Fixed Rate Task executed at: " + System.currentTimeMillis()), 1, 3, TimeUnit.SECONDS);

        scheduler.scheduleWithFixedDelay(() -> System.out.println("Fixed Delay Task executed at: " + System.currentTimeMillis()), 1, 3, TimeUnit.SECONDS);

        scheduler.schedule(() -> {
            System.out.println("Shutting down");
            scheduler.shutdown();
        },10, TimeUnit.SECONDS);
    }
}

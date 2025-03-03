package multithreading;

import java.time.LocalDateTime;

class Task implements Runnable {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Task [" + name + "] executed on : " + LocalDateTime.now().toString() + " " + Thread.currentThread().getName());
    }
}
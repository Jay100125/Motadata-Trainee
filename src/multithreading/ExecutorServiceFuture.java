package multithreading;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

class Taskk implements Callable<Integer>
{
    @Override
    public Integer call() throws Exception
    {
        return new Random().nextInt(6)+5;
    }
}


public class ExecutorServiceFuture
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        ExecutorService service  = Executors.newFixedThreadPool(10);

        List<Future> allFutures = new ArrayList<>();

        for(int index = 0; index<100; index++)
        {
            Future<Integer> future =  service.submit(new Taskk());

            allFutures.add(future);
        }

        for(int index = 0; index<100; index++)
        {
            Future<Integer> future = allFutures.get(index);

            Integer result = future.get();

            System.out.println(result);
        }

        ExecutorService executorService = Executors.newCachedThreadPool();

        System.out.println("Thread name :"+ Thread.currentThread().getName());
        service.shutdown();
    }
}
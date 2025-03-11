package multithreading;

public class InterruptExample extends Thread
{
    @Override
    public void run()
    {

        try
        {
            for(int index=1;index<=5;index++)
            {
                System.out.println(Thread.currentThread().getName() + " " + index);

                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e)
        {
//            e.printStackTrace();
//            Thread.currentThread().interrupt();
        }


        System.out.println(Thread.currentThread().getName() + " is interrupted");
    }

    public static void main(String[] args)
    {
        InterruptExample thread = new InterruptExample();

        thread.start();

        thread.interrupt();

    }


}
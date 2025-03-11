package socketprogramming;

import java.net.InetAddress;

public class InetAddressDemo {
    public static void main(String[] args) {

        try
        {
            InetAddress inetAddress = InetAddress.getByName("google.com");
            System.out.println(inetAddress.getHostAddress());
            System.out.println(inetAddress.getHostName());

            InetAddress inetAddress1 = InetAddress.getLocalHost();
            System.out.println(inetAddress1.getHostName());
            System.out.println(inetAddress1.getHostAddress());
            System.out.println(inetAddress1.getCanonicalHostName());
            System.out.println(inetAddress1.isLoopbackAddress());

            InetAddress inetAddress2 = InetAddress.getByName("google.com");
            System.out.println(inetAddress2.equals(inetAddress));
            System.out.println(inetAddress2.isLoopbackAddress());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

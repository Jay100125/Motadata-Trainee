//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class Sample {
//
//    public static void main(String[] args) throws IOException {
//        String path = "/home/jay";
//        String name = "jay.txt";
//
//        File f = new File(path,name);
//
//        FileOutputStream fos = new FileOutputStream("./src/jay.txt",true);
//        String s = "something";
//        fos.write(s.getBytes());
//        fos.close();
//        f.createNewFile();
//
//        System.out.println("File name "+f.getName());
//        System.out.println("Absolute path "+ f.getAbsolutePath());
//        System.out.println("Parent:" + f.getParent());
//        System.out.println("Exists :" + f.exists());
//        System.out.println("Readable:" + f.canRead());
//        System.out.println("Writable :" + f.canWrite());

import org.w3c.dom.ls.LSOutput;

////
////        String path = "/home/jay";
////        String name = "jay.txt";
////
////        File obj = new File(path,name);
////        obj.createNewFile();
//    }
//
//}
//

//public class Sample {
//
//    private int x=2;
//    void display()
//    {
//        System.out.println("I am in ParentClass");
//        System.out.println(x);
//    }
//
//    class Inner
//    {
//        void show()
//        {
//            System.out.println("I am in inner class ");
//            System.out.println(x);
//        }
//    }
//
//    public static void main(String[] args) {
//
//        Sample Outer = new Sample();
//        Sample.Inner obj = Outer.new Inner();
//        obj.show();
//
//        new Sample().display();
//
//    }
//
//}

//import java.io.BufferedReader;
//
//import java.io.IOException;
//
//import java.io.InputStreamReader;
//
//class Sample
//{
//    public String setIpAddress() throws IOException
//    {
//
//        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
//
//        System.out.println("Enter IP address to Ping");
//
//        String ipAddress = bReader.readLine();
//
//        return ipAddress;
//    }
//
//
//    public static void main(String[] args)
//    {
//        Sample ping_command = new Sample();
//
//        try
//        {
//            if(ping_command == null)
//            {
//                throw new NullPointerException();
//            }
//        }
//        catch(NullPointerException e)
//        {
//            System.out.println(e);
//        }
//
//        String ipAddress="";
//
//        Runtime runtime = null;
//
//        BufferedReader inputReader = null;
//
//        try
//        {
//            ipAddress = ping_command.setIpAddress();
//
//            String pingCmd = "ping -c 3 -w 10 " + ipAddress;
//
//            runtime = Runtime.getRuntime();
//
//            Process commandExec = runtime.exec(pingCmd);
//
//            inputReader = new BufferedReader(new InputStreamReader(commandExec.getInputStream()));
//
//            String pingResult = "";
//
//            if(runtime == null)
//            {
//                throw new NullPointerException();
//            }
//
//            String inputLine="";
//
//            while ((inputLine = inputReader.readLine()) != null)
//            {
//
//                pingResult += inputLine + "\n";
//
//                System.out.println(inputLine);
//
//            }
//
////            System.out.println(pingResult);
//
//            if (pingResult.trim().isEmpty())
//            {
//                System.out.println("Name or service not known otherwise Temporary failure in name resolution");
//            }
//
//            else if (!(pingResult.contains("rtt min/avg/max/mdev")))
//            {
//                System.out.println("Status :- Destination Host Unreachable");
//            }
//
//            else
//            {
//                String[] splited_by_hyphen = pingResult.split("---");
//
//                String[] splited_by_line = splited_by_hyphen[2].split("\n");
//
//                String[] splited_by_comma = splited_by_line[1].split(",");
//
//                System.out.println("\n");
//
//                System.out.println("Status :- Host is Reachable");
//
//                if(splited_by_hyphen[2] != null)
//                {
//                    System.out.println("RTT Minimum value is :- " + splited_by_line[2].split("/")[3].split("=")[1].trim());
//
//                    System.out.println("RTT Average value is :- " + splited_by_line[2].split("/")[4].trim());
//
//                    System.out.println("RTT Maximum value is :- " + splited_by_line[2].split("/")[5].trim());
//                }
//
//                if(splited_by_comma[0] != null)
//                {
//                    System.out.println("Total Packets Transmitted :- " + splited_by_comma[0].trim().split(" ")[0]);
//                }
//
//                if(splited_by_comma[1] != null)
//                {
//                    System.out.println("Total Packets Received :- " + splited_by_comma[1].trim().split(" ")[0]);
//                }
//
//                if(splited_by_comma[2] != null)
//                {
//                    System.out.println("Total Packets Loss :- " + splited_by_comma[2].trim().split(" ")[0]);
//                }
//            }
//
//        }
//        catch (Exception e) //generic exception
//        {
//            System.out.println(e);
//        }
//
//        finally
//        {
//            try
//            {
//                if(inputReader==null)
//                {
//                    inputReader.close();
//                }
//            }
//            catch (IOException e)
//            {
//                System.out.println("Buffer reader doesn't close");
//
//                System.out.println(e);
//            }
//
//        }
//
//    }
//}

import java.io.*;
import java.io.Serializable;
 class Student implements Serializable{
    int id;
    String name;
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
public class Sample{
    static void display()
    {
        System.out.println("Hello I am in Dispaly");
    }

    void show()
    {
        this.display();
    }

    Integer print(){
        return 1;
    }
    public static void main(String args[]){

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
//        System.out.println(new Sample().print());
    }
}
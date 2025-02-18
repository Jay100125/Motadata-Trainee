package FileIO;

import java.io.*;
import java.nio.Buffer;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Pattern;

// a disk read means something is physically or mechanically ocurring on your hard disk to read that character from the file
// this is expensive in terms of time and resource usage.
// |
// file buffer
/* file buffer is just computer memory temp used to hold data while it's being read from a file

* */

//FileReader is meant for reading streams of characters. For reading streams of raw bytes, consider using a FileInputStream.

class ReadOneChar{
    void readSomething() {
        try (FileReader reader = new FileReader("output.txt")) {
            int data;
            //The read() method reads and passes a single character or -1 if the stream is ended.
            while ((data = reader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class BufferReader{
    void readSomething() {
        try(BufferedReader bufferReader = new BufferedReader(new FileReader("output.txt")))
        {
//            String line;
//            while((line = bufferReader.readLine()) != null)
//            {
//                System.out.println(line);
//            }

            Pattern pattern = Pattern.compile("(\\p{javaWhitespace}+)");
            //count the number of words

            System.out.printf("%d words in a file%n", bufferReader.lines().flatMap(pattern::splitAsStream).count());
            // bufferReader.lines().forEach(System.out::println)
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}

class ReadUsingScanner{
    void readSomething() {
        try {
            Scanner scanner = new Scanner(new File("output.txt"));

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
//            scanner.useDelimiter("\n");
//            scanner.tokens().forEach(System.out::println);
        } catch  (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

//class ReadUsingNIO
//{
//    void readSomething() {
//        System.out.println(System.getProperty("");
//    }
//}
public class ReadingFiles {
    public static void main(String[] args) {
        // one charcter at a time
        try(FileReader reader = new FileReader("output.txt")){
            int data;
            char[] block = new char[1024];
            //read a stream of characters and stores them in the given Character buffer
            while((data = reader.read(block)) != -1)
            {
                String content = new String(block,0,data);
//                System.out.println((char)data);
                System.out.printf("---> [%d chars] %s%n", data,content);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("_________________________________");

        BufferReader bufferReader = new BufferReader();
        bufferReader.readSomething();

        System.out.println("_________________________________");

        ReadUsingScanner readUsingScanner = new ReadUsingScanner();
        readUsingScanner.readSomething();
    }
}

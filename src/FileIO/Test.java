package codes.practicals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * FileWriter and FileReader are used for directly writing into files with platform's default character encoding, which varies by operating system
 *  - It is reading and writing one char ( 16bit ) at a time
 *
 * FileOutputStream and FileInputStream are used for writing and retrieving data from files as bytes
 *  - It is reading and writing one byte at a time
 *
 * BufferReader and BufferWriter are used for writing and retrieving data in buffer of 8 or 16KB
 *  - They don't handle file operations directly - they need to be combined with FileReader/FileWriter
 *
 */

public class Test {


    public static void main(String[] args) {
        /*
        try{
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

            String line;
            int wc = 0;
            while((line=reader.readLine()) != null){
                String[] t = line.split("\\s+");
                wc += t.length;
            }

            writer.write(""+(wc));
            writer.close();

        }
        catch(FileNotFoundException fe){
            System.out.println(fe.getMessage());
        }
        catch(IOException ie){
            System.out.println(ie.getMessage());
        }
    */

        fileInputOutputStream();
    }


    public static void fileInputOutputStream() {
        try{
            // HOW TO READ FILE
            FileInputStream input = new FileInputStream("input.txt");
            int byteData;

            while( (byteData=input.read()) != -1){
                System.out.print((char)byteData);
            }
            input.close();

            // HOW TO WRITE FILE
            FileOutputStream outputStream = new FileOutputStream("output.txt", true); // true is for append
            outputStream.write("\nHEY".getBytes());
            outputStream.close();

        } catch(FileNotFoundException fe){
            System.out.println(fe.getMessage());
        } catch(IOException ie){
            System.out.println(ie.getMessage());
        }
    }

    public static void bufferReaderWriter(){
        try{
            // HOW TO READ
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String line;

            while( (line = reader.readLine()) != null){
                System.out.println(line);
            }

            // HOW TO WRITE
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("Har Har Mahadev");
            writer.close(); // or writer.flush() for flushing out all buffered data
        } catch(FileNotFoundException fe){
            System.out.println(fe.getMessage());
        } catch(IOException ie){
            System.out.println(ie.getMessage());
        }
    }

    public static void fileReaderWriter() {
        try{
            // HOW TO READ
            FileReader reader = new FileReader("input.txt");
            int charData;

            while( (charData = reader.read()) != -1){
                System.out.print((char) charData);
            }
            reader.close(); // Close the reader after use

            // HOW TO WRITE
            FileWriter writer = new FileWriter("output.txt", true); // true is for append
            writer.write("\nHar Har Mahadev");
            writer.close(); // Always close writer to release resources

        } catch(FileNotFoundException fe){
            System.out.println("File not found: " + fe.getMessage());
        } catch(IOException ie){
            System.out.println("I/O error: " + ie.getMessage());
        }
    }

}
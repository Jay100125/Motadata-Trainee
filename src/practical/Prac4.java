package practical;

import java.io.*;
import java.util.Scanner;

public class Prac4 {
    public static void main(String[] args) {

        String inputFilePath = "./src/practical/input.txt";
        String outputFilePath = "./src/practical/output.txt";

        try {
            File inputFile = new File(inputFilePath);
            Scanner scanner = new Scanner(inputFile);
            int wordCount = 0;

            while (scanner.hasNext()) {
                scanner.next();
                wordCount++;
            }
            scanner.close();

            FileWriter writer = new FileWriter(outputFilePath);
            writer.write("Word count: " + wordCount);
            writer.close();

            System.out.println("Word count written to output.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error: Unable to write to file.");
        }
    }
}


//        int wordCount = 0;
//        try (FileInputStream fis = new FileInputStream(inputFilePath)) {
//            StringBuilder content = new StringBuilder();
//            int data;
//            // Read the file byte by byte
//            while ((data = fis.read()) != -1) {
//                content.append((char) data); // Convert byte to char and append to content
//            }
//
//            // Split the content into words and count them
//            String[] words = content.toString().split("\\s+"); // Split by whitespace
//            wordCount = words.length;
//            System.out.println("Word count: " + wordCount);
//        }catch (FileNotFoundException e) {
//            System.out.println("File not found");
//            return;
//        }
//        catch (IOException e) {
//            System.err.println("Error: Unable to read input file: " + e.getMessage());
//            return; // Exit the program if there's an error
//        }
//
//        // Write the word count to the output file
//        try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
//            String outputText = "Number of words: " + wordCount;
//            fos.write(outputText.getBytes()); // Write the output text as bytes
//            System.out.println("Word count written to " + outputFilePath);
//        }
//        catch (FileNotFoundException e) {
//            System.out.println("File not found");
//
//        }
//        catch (IOException e) {
//            System.err.println("Error: Unable to write to output file: " + e.getMessage());
//
//        }

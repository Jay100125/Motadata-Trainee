package practical;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Prac17 {
    public static void main(String[] args) {
        String path = "./pathfile.txt";
        String appendContent = "This is appended content\n.";

//        File file = new File(path);
        // you can also pass file object..
        try(FileWriter fileWriter = new FileWriter(path, true)) { //true enables append
            fileWriter.append(appendContent);
            System.out.println("File written to " + path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package practical;

import java.io.File;

public class Prac16 {
    public static void main(String[] args) {

        String directoryPath = "./src/practical";
        String extension = ".txt";

        File file = new File(directoryPath);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().endsWith(extension)) {
                System.out.println(files[i].getName());
            }
        }
    }
}

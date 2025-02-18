package practical;

import java.io.*;

public class Prac14 {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("output.txt"));
            String line;
//            int wc = 0;
            while((line = br.readLine()) != null){
                int wc = 0;
                String[] arr = line.trim().split("\\s+");
                wc += arr.length;
                System.out.printf("%d ", wc);
            }
//            System.out.println(wc);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

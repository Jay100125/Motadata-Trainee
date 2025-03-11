package extra;

import java.io.*;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
//        prop.setProperty("name", "John");
//        prop.setProperty("age", "25");
//
//
//        OutputStream os = new FileOutputStream("./src/extra/test.properties");
//
//        prop.store(os, null);
//        System.out.println(prop);

        InputStream is = new FileInputStream("./src/extra/test.properties");
        prop.load(is);

        System.out.println(prop.getProperty("bday"));

    }
}

package practical;

import java.io.File;

public class Prac16 {
//    public static void list(String directoryPath) {
//
//        String extension = ".txt";
//        File file = new File(directoryPath);
//        File[] files = file.listFiles();
//        for (int i = 0; i < files.length; i++) {
//            if(files[i].isDirectory())
//            {
//                list(files[i].getPath());
//            }
//            if (files[i].getName().endsWith(extension)) {
//                System.out.println(files[i].getName());
//            }
//        }
//    }
public static void list(String path){
    File dir = new File(path);

    File[] files = dir.listFiles();
    for(int i = 0; i < files.length; i++){
        if(files[i].isDirectory()){
            list(files[i].getPath());
        }
        if(files[i].getName().endsWith(".txt")){
            System.out.println(files[i].getAbsoluteFile()  +""+ files[i].getName());
        }
    }
}

    public static void main(String[] args) {
        String directoryPath = "./src";
        list(directoryPath);

    }
}

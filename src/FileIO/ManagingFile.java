package FileIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ManagingFile {
    public static void main(String[] args) {
//        File oldFile = new File("./src/FileIO/students.json");
//        File newFile = new File("student-activity.json");
//
//        if(oldFile.exists()){
//            oldFile.renameTo(newFile);
//            System.out.println("Rename old file to new file");
//        }else {
//            System.out.println("File does not exist");
//        }

//        Path oldPath = Path.of("students.json");
//        Path newPath = Path.of("files/student-activity.json");
//
//        try{
//            Files.createDirectories(newPath.subpath(0,newPath.getNameCount()-1));
//            Files.move(oldPath, newPath);
//            System.out.println("Moved old file to new file");
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        Path fileDir = Path.of("files");
        Path resourceDir = Path.of("resources");

        try{
            Files.copy(fileDir, resourceDir);
            System.out.println("Directory copied");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }
}

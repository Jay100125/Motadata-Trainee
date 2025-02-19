package FileIO;
// helps in logs
// storing configuration data
// exporting data for exchange of information
// supporting offline usage in a file cache

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class WritingFiles {
    public static void main(String[] args) {


        String header = """
                Studnet Id, Country Code, Enrolled Year, Age, Gender,\
                Experienced Course Code, Engagement Month, Engagement Year,\
                Engagement Type
                """;

        Course jmc = new Course("JMC", "Java MasterClass");
        Course pymc = new Course("Pymc", "Python MasterClass");

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc)).limit(5).toList();

//        System.out.println(header);
//        students.forEach(s -> s.getEngagementRecords().forEach(System.out::println));

        Path path = Path.of("students.csv");

//        try{
//            Files.writeString(path, header);
//            for(Student student : students){
//                Files.write(path,student.getEngagementRecords(), StandardOpenOption.APPEND);
//            }
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }

        try{
            List<String> data = new ArrayList<>();
            data.add(header);
            for(Student student : students){
                data.addAll(student.getEngagementRecords());
            }
            Files.write(path, data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try(BufferedWriter writer = Files.newBufferedWriter(Path.of("take2.csv"))){
            writer.write(header);
            for(Student student : students){
                for(var record : student.getEngagementRecords()){
                    writer.write(record);
                    writer.newLine();
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

        try(FileWriter writer = new FileWriter("take3.csv")){
            writer.write(header);
            for(Student student : students){
                for(var record : student.getEngagementRecords()){
                    writer.write(record);
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

        try(PrintWriter writer = new PrintWriter("take4.csv")){
            writer.write(header);
            for(Student student : students){
                for(var record : student.getEngagementRecords()){
                    writer.println(record);
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}

// BufferWriter
// buffering - yes
// data format :- characters
//features :- support line breaks with newline method
// use case :- writing large amounts of text to a file

// fileWriter
// buffering - yes, but much smaller than bufferedwriter
// data format :- characters
//features :- no separate method for line separators, would need to write manually
// use case :- writing small amounts of text to a file


// PrintWriter
// buffering - no, but often used with bufferedwriter
// data format :- characters, number and objects
//features :- fimiliar methods, that have same behavior as System.out.methods
// use case :- writing text to a file, formatting output, and outputting objects

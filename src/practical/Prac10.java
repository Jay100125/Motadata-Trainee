package practical;

import java.io.FileWriter;
import java.time.LocalDate;

class Logger{

    private static Logger instance;

    private FileWriter fileWriter;

    private Logger(){
        try{

            fileWriter = new FileWriter("application.log",true);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message){
        try{
            fileWriter.write(message + "\n");
            fileWriter.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void closeLog(){
        try{
            fileWriter.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
public class Prac10 {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.log("Hello World");
        logger.log("Something's on the way!!!");

        logger.closeLog();
    }
}

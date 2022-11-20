package ContactBook.Implement;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;


public class LoggerClass {
    private String path;

//    public static void main(String[] args) {
//        //logGer();
//        log3();
//    }
    public LoggerClass()
    {}
    private void logGer() {
        String path = System.getProperty("user.dir");
        File file = new File("Log1.txt");
        boolean b = file.exists();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception ex) {
                String e = ex.getMessage();
            }
        }
        var s = file.getAbsolutePath();
        try {
            //Logger logger = Logger
        } catch (Exception ex)
        {}
    }
    public void log(String message)
    {
        Date date = new Date();
        var t = date.toString();
        try(FileWriter fw = new FileWriter("log.txt", true))
        {
            fw.write("%s\t|Date:%s|\n".formatted(message, t));
            fw.flush();
        }
        catch (Exception ex)
        {}
    }
}

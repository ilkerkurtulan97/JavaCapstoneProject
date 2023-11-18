package Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LogHandler{

    private static final String LOG_DIRECTORY = "logs";

    //Creating LogFile
    public static void createLogFile(String className) {
        String fileName = className + "_log.txt";
        File logFile = new File(LOG_DIRECTORY, fileName);

        if (!logFile.exists()) {
            try {
                Files.createDirectories(Paths.get(LOG_DIRECTORY));
                logFile.createNewFile();
                System.out.println("Log file created: " + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Move/rename log file
    public static void moveLogFile(String oldClassName, String newClassName) {
        String oldFileName = oldClassName + "_log.txt";
        String newFileName = newClassName + "_log.txt";
        File oldFile = new File(LOG_DIRECTORY, oldFileName);
        File newFile = new File(LOG_DIRECTORY, newFileName);

        if (oldFile.exists()) {
            oldFile.renameTo(newFile);
            System.out.println("Log file moved from " + oldFileName + " to " + newFileName);
        }
    }

    //Delete LogFile method
    public static void deleteLogFile(String className) {
        String fileName = className + "_log.txt";
        File logFile = new File(LOG_DIRECTORY, fileName);

        if (logFile.exists()) {
            logFile.delete();
            System.out.println("Log file deleted: " + fileName);
        }
    }

}
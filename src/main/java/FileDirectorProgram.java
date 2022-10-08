import org.apache.commons.io.*;
import java.io.File;
import java.io.IOException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDirectorProgram {




    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Maksymilian\\IdeaProjects\\ChoseTheDirectory\\Home");
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Folder został stworzony ");
            }
        }
        File test = new File("C:\\Users\\Maksymilian\\IdeaProjects\\ChoseTheDirectory\\Home\\Test");
        if (!test.exists()) {
            test.mkdir();
        }
        File dev = new File("C:\\Users\\Maksymilian\\IdeaProjects\\ChoseTheDirectory\\Home\\Dev");
        if (!dev.exists()) {
            dev.mkdir();
        }
        File count = new File("C:\\Users\\Maksymilian\\IdeaProjects\\ChoseTheDirectory\\Home\\count.txt");
        if(!count.exists()){
            count.createNewFile();
        }

        }


    }


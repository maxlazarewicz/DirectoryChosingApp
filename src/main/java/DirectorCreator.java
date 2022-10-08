import org.apache.commons.io.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class DirectorCreator {
    public static void main(String[] args) throws IOException {
        String path = "Home" + File.separator + "Dev";
        File file = new File( path );
        file.mkdirs();
        String path1 = "Home" + File.separator + "Test";
        File file1 = new File( path1 );
        file1.mkdirs();
        String path2 = "Home" + File.separator + "count.txt";
        File count  = new File(path2);
        count.createNewFile();
    }



}

package watcher;


import counting.CountingWriter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Date;


public class FileExtensionStrategy {
    CountingWriter countingWriter = new CountingWriter();

    public void extensionStrategy(Path path) throws IOException {
       String extension = FilenameUtils.getExtension(path.toString());
       switch(extension){
           case "jar":
               Date date = getCreationDate(path);
               if(date.getHours()%2==0){
                   moveFileToDirectory(path, "Dev");
                   countingWriter.devDirectoryCounter();
                   break;
               }else{
                   moveFileToDirectory(path, "Test");
                   countingWriter.testDirectoryCounter();
               }

               case "xml":
               moveFileToDirectory(path, "Dev");
                   countingWriter.devDirectoryCounter();
                   break;
       }
   }
    private void moveFileToDirectory(Path path, String dest) throws IOException {
       File from = new File(path.toString());
        String absolutePath = getAbsolutePath();
        String dir = new StringBuffer(absolutePath).append("/").append(dest).toString();

        File to = new File(dir);
        FileUtils.moveFileToDirectory(from, to, false);
    }

    private String getAbsolutePath() {
        Path currentRelativePath = Paths.get("");

        return currentRelativePath.toAbsolutePath().toString();
    }
    private Date getCreationDate (Path path) throws IOException {
        BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
        FileTime fileTime = attributes.creationTime();

        return  new Date(fileTime.toMillis());
   }
}


package init;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DirectoryInit {

    public void directoryCreator() {
        List<String> directories = Arrays.asList("Home", "Dev", "Test");
        for (String director : directories) {
            File file = new File(director);
            if (!file.exists()) {
                try {
                    file.mkdir();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

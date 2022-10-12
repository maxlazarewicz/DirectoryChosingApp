package init;

import java.io.File;
import java.io.IOException;

public class FileInit {
    private static final String path = "home" + File.separator + "count.txt";

    public void fileCreator() {

        File count = new File(path);
        if (!count.exists()) {
            try {
                count.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

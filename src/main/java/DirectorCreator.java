import init.FacadeInit;
import watcher.Watcher;

import java.io.IOException;

public class DirectorCreator {

    public static void main(String[] args) throws IOException, InterruptedException {
        FacadeInit facadeInit = new FacadeInit();
        Watcher watcher = new Watcher();

        facadeInit.setUp();
        watcher.watcher();
    }

}

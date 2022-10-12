package init;

public class FacadeInit {

    public void setUp(){
        DirectoryInit directoryInit = new DirectoryInit();
        FileInit fileInit = new FileInit();

        directoryInit.directoryCreator();
        fileInit.fileCreator();
    }
}

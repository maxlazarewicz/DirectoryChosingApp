package watcher;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;

public class Watcher {
    private FileExtensionStrategy strategy = new FileExtensionStrategy();

    public void watcher() throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = Paths.get(getAbsolutePath());
        path.register(watchService, ENTRY_CREATE);
        boolean poll = true;
        while (poll) {
            WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                if (event.kind() == ENTRY_CREATE) {
                    Path file = getPathFromWatchEvent(key, event);
                    strategy.extensionStrategy(file);
                }

            }
            poll = key.reset();
        }
    }

    private Path getPathFromWatchEvent(WatchKey key, WatchEvent<?> event) {
        Path dir = (Path) key.watchable();

        return dir.resolve((Path) event.context());
    }

    private String getAbsolutePath() {
        Path currentRelativePath = Paths.get("");
        String absolutePath = currentRelativePath.toAbsolutePath().toString();

        return
                new StringBuffer(absolutePath).append("/Home").toString();
    }
}

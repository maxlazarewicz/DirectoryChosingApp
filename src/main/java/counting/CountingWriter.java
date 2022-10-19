package counting;

        import java.io.BufferedWriter;
        import java.io.FileWriter;
        import java.io.IOException;

public class CountingWriter {
    static int devDirectory = 0;
    static int testDirectory = 0;

    public void devDirectoryCounter() throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Home\\count.txt", true));

            devDirectory++;

            String totalMessage = "\n" + "Total number of files moved to folders ";
            String message = "\n" + "The number of times the file was moved to the dev folder ";

            bufferedWriter.append(message + devDirectory);
            bufferedWriter.append(totalMessage + (devDirectory + testDirectory));

            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testDirectoryCounter() throws IOException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Home\\count.txt", true));

            testDirectory++;

            String totalMessage = "\n" + "Total number of files moved to folders ";
            String message = "\n" + "The number of times the file was moved to the test folder";

            bufferedWriter.append(message + testDirectory);
            bufferedWriter.append(totalMessage + (devDirectory + testDirectory));

            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

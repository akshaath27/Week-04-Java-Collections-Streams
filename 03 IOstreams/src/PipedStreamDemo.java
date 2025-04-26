import java.io.*;

public class PipedStreamDemo {
    public static void main(String[] args) {
        try {
            // Create piped streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos); // Connects input to output

            // Writer thread
            Thread writerThread = new Thread(() -> {
                try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(pos))) {
                    String[] messages = {"Hello", "from", "the", "writer", "thread!"};
                    for (String msg : messages) {
                        writer.write(msg);
                        writer.newLine(); // newline acts as a delimiter
                        writer.flush();   // ensure message is sent immediately
                        Thread.sleep(500); // simulate delay
                    }
                } catch (IOException | InterruptedException e) {
                    System.err.println("Writer thread error: " + e.getMessage());
                }
            });

            // Reader thread
            Thread readerThread = new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(pis))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println("Reader received: " + line);
                    }
                } catch (IOException e) {
                    System.err.println("Reader thread error: " + e.getMessage());
                }
            });

            // Start threads
            readerThread.start();
            writerThread.start();

            // Wait for both to complete
            writerThread.join();
            readerThread.join();

        } catch (IOException | InterruptedException e) {
            System.err.println("Main thread error: " + e.getMessage());
        }
    }
}

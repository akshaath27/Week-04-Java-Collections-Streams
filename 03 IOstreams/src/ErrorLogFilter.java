import java.io.*;

public class ErrorLogFilter {
    public static void main(String[] args) {
        String filePath = "large_log.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                    count++;
                }
            }
            System.out.println("\nTotal lines containing 'error': " + count);
        } catch (IOException e) {
            System.err.println("Failed to read file: " + e.getMessage());
        }
    }
}

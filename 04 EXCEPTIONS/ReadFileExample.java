package EXCEPTIONS;
import java.io.*;
public class ReadFileExample {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\KEERTHANA\\eclipse-workspace\\JAVA\\src\\text";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}

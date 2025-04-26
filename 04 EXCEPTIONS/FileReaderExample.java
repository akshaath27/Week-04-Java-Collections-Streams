package EXCEPTIONS;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        String fileName = "C:\\\\Users\\\\KEERTHANA\\\\eclipse-workspace\\\\JAVA\\\\src\\\\text";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String firstLine = reader.readLine();
            System.out.println(firstLine != null ? firstLine : "File is empty.");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}


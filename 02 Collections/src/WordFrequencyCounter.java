import java.io.*;
import java.util.*;

public class WordFrequencyCounter {

    public static void countWordFrequency(String fileName) throws IOException {
        File file = new File(fileName);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        Map<String, Integer> wordFrequency = new HashMap<>();

        while ((line = reader.readLine()) != null) {
            String[] words = line.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        }

        reader.close();

        System.out.println(wordFrequency);
    }

    public static void main(String[] args) {
        try {
            countWordFrequency("C:\\Users\\YourName\\Documents\\text.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

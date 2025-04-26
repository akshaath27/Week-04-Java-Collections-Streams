import java.util.regex.*;

public class BadWordCensor {
    public static String censorBadWords(String text, String[] badWords) {
        for (String word : badWords) {
            text = text.replaceAll("\\b" + word + "\\b", "****");
        }
        return text;
    }

    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"};
        String output = censorBadWords(input, badWords);
        System.out.println(output);
    }
}

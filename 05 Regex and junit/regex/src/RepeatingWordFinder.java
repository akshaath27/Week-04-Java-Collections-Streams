import java.util.regex.*;
import java.util.*;

public class RepeatingWordFinder {
    public static Set<String> findRepeatingWords(String text) {
        Set<String> repeatingWords = new HashSet<>();
        Matcher matcher = Pattern.compile("\\b(\\w+)\\b(?=.*\\b\\1\\b)").matcher(text);
        while (matcher.find()) {
            repeatingWords.add(matcher.group());
        }
        return repeatingWords;
    }

    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        Set<String> words = findRepeatingWords(text);

        System.out.println(String.join(", ", words));
    }
}

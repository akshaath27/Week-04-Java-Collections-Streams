import java.util.regex.*;
import java.util.*;

public class CurrencyExtractor {
    public static List<String> extractCurrencyValues(String text) {
        List<String> currencyValues = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\$?\\d+(\\.\\d{2})?").matcher(text);
        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }
        return currencyValues;
    }

    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";
        List<String> values = extractCurrencyValues(text);

        System.out.println(String.join(", ", values));
    }
}

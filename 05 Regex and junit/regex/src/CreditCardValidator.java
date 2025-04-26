import java.util.regex.*;

public class CreditCardValidator {
    public static boolean isValidCreditCard(String cardNumber) {
        return cardNumber.matches("^4\\d{15}$") || cardNumber.matches("^5\\d{15}$");
    }

    public static void main(String[] args) {
        String[] testCards = {"4123456789012345", "5123456789012345", "6123456789012345"};

        for (String card : testCards) {
            System.out.println(card + " → " + (isValidCreditCard(card) ? "✅ Valid" : "❌ Invalid"));
        }
    }
}

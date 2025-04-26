import java.util.regex.*;

public class SSNValidator {
    public static boolean isValidSSN(String ssn) {
        return ssn.matches("^\\d{3}-\\d{2}-\\d{4}$");
    }

    public static void main(String[] args) {
        String[] testSSNs = {"123-45-6789", "123456789", "987-65-4321"};

        for (String ssn : testSSNs) {
            System.out.println(ssn + " → " + (isValidSSN(ssn) ? "✅ Valid" : "❌ Invalid"));
        }
    }
}

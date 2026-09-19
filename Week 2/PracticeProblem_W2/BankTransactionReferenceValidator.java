import java.util.Scanner;

public class BankTransactionReferenceValidator {

    static String normalizeReference(String raw) {
        String reference = raw.trim();

        if (reference.length() < 3) {
            return reference;
        }

        String bankCode = reference.substring(0, 3).toUpperCase();
        String remaining = reference.substring(3);

        return bankCode + remaining;
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String sequence = reference.substring(9, 14);

        for (int i = 0; i < bankCode.length(); i++) {
            if (!Character.isLetter(bankCode.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 0; i < date.length(); i++) {
            if (!Character.isDigit(date.charAt(i))) {
                return "Invalid: date must contain digits";
            }
        }

        for (int i = 0; i < sequence.length(); i++) {
            if (!Character.isDigit(sequence.charAt(i))) {
                return "Invalid: sequence must contain digits";
            }
        }

        StringBuilder formattedReference = new StringBuilder();

        formattedReference.append("[")
                .append(bankCode)
                .append("] DATE: ")
                .append(date.substring(0, 2))
                .append("/")
                .append(date.substring(2, 4))
                .append("/")
                .append(date.substring(4, 6))
                .append(" | SEQ: ")
                .append(sequence);

        return formattedReference.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String rawReference = scanner.nextLine();

        String normalizedReference = normalizeReference(rawReference);

        String result = validateAndFormat(normalizedReference);

        System.out.println(result);

        scanner.close();
    }
}
package lab17;

public class INNValidator {
    public static boolean isValidINN(String fullName, String inn) {
        if (fullName == null || inn == null || fullName.isEmpty() || inn.isEmpty()) {
            throw new IllegalArgumentException("Full name and INN cannot be null or empty.");
        }

        if (!isValidINNLength(inn)) {
            throw new IllegalArgumentException("INN length should be either 10 or 12 digits.");
        }

        if (!isNumeric(inn)) {
            throw new IllegalArgumentException("INN should contain only numeric digits.");
        }

        return true;
    }

    private static boolean isValidINNLength(String inn) {
        int length = inn.length();
        return length == 10 || length == 12;
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }


    public static void main(String[] args) {
        String fullName = "John Doe";
        String innNumber = "1234567890";

        try {
            boolean isValid = isValidINN(fullName, innNumber);
            if (isValid) {
                System.out.println("Valid INN for the client.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid INN: " + e.getMessage());
        }
    }
}


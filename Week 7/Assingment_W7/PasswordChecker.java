public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password != null ? password : "";
    }

    public String getStrength() {
        int length = password.length();
        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("Strength of 'abcd': " + pc1.getStrength()); 
        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println("Strength of 'abcdefgh': " + pc2.getStrength()); 

        PasswordChecker pc3 = new PasswordChecker("abcdefghij");
        System.out.println("Strength of 'abcdefghij': " + pc3.getStrength()); 
}
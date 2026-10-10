public class Locker {
    private final int lockerNumber;
    private String combinationCode;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = initialCode;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (this.combinationCode.equals(currentCode)) {
            this.combinationCode = newCode;
            System.out.println("Success: Locker code updated.");
            return true;
        }
        System.out.println("Rejected: Incorrect current code.");
        return false;
    }

    public int getLockerNumber() {
        return this.lockerNumber;
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        l.changeCode("1234", "5678"); // Success
        l.changeCode("0000", "9999"); // Rejected
    }
}
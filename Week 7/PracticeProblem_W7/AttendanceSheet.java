public class AttendanceSheet {
    private final String[] presentStudents;
    private int presentCount;

    public AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.presentCount = 0;
    }

    public void markPresent(String studentName) {
        if (isPresent(studentName)) {
            return; // Prevent duplicate entries
        }
        if (presentCount < presentStudents.length) {
            presentStudents[presentCount++] = studentName;
        }
    }

    public boolean isPresent(String studentName) {
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equalsIgnoreCase(studentName)) {
                return true;
            }
        }
        return false;
    }

    public int getPresentCount() {
        return this.presentCount;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana"); // Duplicate ignored

        System.out.println("Present count: " + sheet.getPresentCount()); // 2
        System.out.println("Is Ben present? " + sheet.isPresent("Ben")); // true
        System.out.println("Is Chen present? " + sheet.isPresent("Chen")); // false
    }
}
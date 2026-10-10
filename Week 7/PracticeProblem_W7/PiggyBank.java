public class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.savings += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) return;
        if (amount <= this.savings) {
            this.savings -= amount;
        } else {
            System.out.println("Withdrawal rejected: Insufficient funds.");
        }
    }

    public double getSavings() {
        return this.savings;
    }

    public String getId() {
        return this.id;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        
        pb.deposit(100);
        System.out.println("Savings after depositing 100: " + pb.getSavings()); // 100.0

        pb.withdraw(30);
        System.out.println("Savings after withdrawing 30: " + pb.getSavings()); // 70.0

        pb.withdraw(500); // Rejected
        System.out.println("Savings after invalid withdrawal: " + pb.getSavings()); // 70.0
    }
}

public class Cart {
    private final String id;
    private final double[] prices;
    private int itemCount;

    public Cart(String id, int capacity) {
        this.id = id;
        this.prices = new double[capacity];
        this.itemCount = 0;
    }

    public boolean addItem(double price) {
        if (itemCount < prices.length) {
            prices[itemCount++] = price;
            return true;
        }
        return false; 
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return this.itemCount;
    }

    public String getId() {
        return this.id;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal()); 
        System.out.println("Item Count: " + cart.getItemCount()); 
    }
}
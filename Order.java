import java.util.ArrayList;

public class Order {
    private final String orderId;
    private final Customer customer;
    private final ArrayList<Book> items;
    private final double totalAmount;

    public Order(String orderId, Customer customer, ArrayList<Book> items) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = items;
        this.totalAmount = calculateTotal();
    }

    private double calculateTotal() {
        double total = 0;
        for (Book item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void placeOrder() {
        System.out.println("Order placed for: " + customer.getName() +
                "\nTotal Amount: Rp" + totalAmount);
        System.out.println(" ");
        System.out.println("Order Details:\n" + this.toString());
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder();
        for (Book item : items) {
            details.append(item.toString()).append("\n\n");
        }
        return details.toString();
    }
}

import java.util.ArrayList;

public class Cart {
    private final ArrayList<Book> items;

    public Cart() {
        items = new ArrayList<>();
    }

    // Overloaded method to add an EBook
    public void addEBook(String title, String author, double price, String isbn, double fileSize, String format) {
        items.add(new EBook(title, author, price, isbn, fileSize, format));
    }

    // Overloaded method to add a PhysicalBook
    public void addPhysicalBook(String title, String author, double price, String isbn, double weight, String dimensions) {
        items.add(new PhysicalBook(title, author, price, isbn, weight, dimensions));
    }

    // Original method to add a Book object
    public void addItem(Book item) {
        items.add(item);
    }

    public void removeItem(String isbn) {
        items.removeIf(book -> book.getIsbn().equals(isbn));
    }

    public void displayCart() {
        for (Book item : items) {
            System.out.println(item.toString() + "\n");
        }
    }

    public ArrayList<Book> getItems() {
        return items;
    }
}

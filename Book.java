public abstract class Book implements Purchasable {
    private final String title;
    private final String author;
    private final double price;
    private final String isbn;

    public Book(String title, String author, double price, String isbn) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author + "\nPrice: Rp" + price + "\nISBN: " + isbn;
    }

    public final void displayDetails() {
        System.out.println(toString());
    }
}

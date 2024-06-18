public class PhysicalBook extends Book {
    private final double weight;
    private final String dimensions;

    public PhysicalBook(String title, String author, double price, String isbn, double weight, String dimensions) {
        super(title, author, price, isbn);
        this.weight = weight;
        this.dimensions = dimensions;
    }

    public PhysicalBook(String title, String author, double price, String isbn, double weight) {
        this(title, author, price, isbn, weight, "Not Specified");
    }

    @Override
    public void purchase() {
        System.out.println("Purchasing physical book: " + getTitle());
    }

    @Override
    public String toString() {
        return "Physical Book " + super.toString() + "\nWeight: " + weight + "kg\nDimensions: " + dimensions;
    }
}

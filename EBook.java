public class EBook extends Book {
    private final double fileSize;
    private final String format;

    public EBook(String title, String author, double price, String isbn, double fileSize, String format) {
        super(title, author, price, isbn);
        this.fileSize = fileSize;
        this.format = format;
    }

    public EBook(String title, String author, double price, String isbn, double fileSize) {
        this(title, author, price, isbn, fileSize, "PDF");
    }

    @Override
    public void purchase() {
        System.out.println("Purchasing ebook: " + getTitle());
    }

    @Override
    public String toString() {
        return "EBook " + super.toString() + "\nFile Size: " + fileSize + "MB\nFormat: " + format;
    }
}

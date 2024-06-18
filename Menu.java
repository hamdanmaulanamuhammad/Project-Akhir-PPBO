import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final ArrayList<Book> bookList;

    public Menu(Scanner scanner, ArrayList<Book> bookList) {
        this.scanner = scanner;
        this.bookList = bookList;
    }

    public void addPhysicalBookToList() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter weight (kg): ");
        double weight = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter dimensions: ");
        String dimensions = scanner.nextLine();

        if (dimensions.isEmpty()) {
            bookList.add(new PhysicalBook(title, author, price, isbn, weight, "Not Specified"));
        } else {
            bookList.add(new PhysicalBook(title, author, price, isbn, weight, dimensions));
        }

        System.out.println("PhysicalBook added to list.");
    }

    public void addEBookToList() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter file size (MB): ");
        double fileSize = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter format: ");
        String format = scanner.nextLine();

        if (format.isEmpty()) {
            bookList.add(new EBook(title, author, price, isbn, fileSize, "PDF"));
        } else {
            bookList.add(new EBook(title, author, price, isbn, fileSize, format));
        }

        System.out.println("EBook added to list.");
    }

    public void displayBookList() {
        if (bookList.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("List of books:");
            for (Book book : bookList) {
                System.out.println("Title: " + book.getTitle() + ", ISBN: " + book.getIsbn());
            }
        }
    }

    public void purchaseBooks() {
        System.out.println("Enter customer details:");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        Customer customer = new Customer(name, email, address);

        ArrayList<Book> itemsToPurchase = new ArrayList<>();
        while (true) {
            System.out.print("Enter ISBN of the book to purchase (or type 'done' to finish): ");
            String isbn = scanner.nextLine();

            if (isbn.equalsIgnoreCase("done")) {
                break;
            }

            Book bookToPurchase = null;
            for (Book book : bookList) {
                if (book.getIsbn().equals(isbn)) {
                    bookToPurchase = book;
                    break;
                }
            }

            if (bookToPurchase == null) {
                System.out.println("Invalid ISBN.");
            } else {
                itemsToPurchase.add(bookToPurchase);
            }
        }

        if (itemsToPurchase.isEmpty()) {
            System.out.println("No valid books selected for purchase.");
        } else {
            Order order = new Order("ORD001", customer, itemsToPurchase);
            order.placeOrder();
        }
    }

    public void removeBookFromList() {
        System.out.print("Enter ISBN of the book to remove: ");
        String isbn = scanner.nextLine();

        Book bookToRemove = null;
        for (Book book : bookList) {
            if (book.getIsbn().equals(isbn)) {
                bookToRemove = book;
                break;
            }
        }

        if (bookToRemove == null) {
            System.out.println("Invalid ISBN.");
        } else {
            bookList.remove(bookToRemove);
            System.out.println("Book removed from list.");
        }
    }
}

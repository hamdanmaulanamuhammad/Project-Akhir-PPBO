import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> bookList = new ArrayList<>();
        Menu menu = new Menu(scanner, bookList);

        while (true) {
            try {
                System.out.println("Choose an option:");
                System.out.println("1. Add PhysicalBook to list");
                System.out.println("2. Add EBook to list");
                System.out.println("3. Display list of books");
                System.out.println("4. Purchase books");
                System.out.println("5. Remove a book from list");
                System.out.println("0. Finish");
                int option = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (option == 0) {
                    break;
                }
                switch (option) {
                    case 1:
                        menu.addPhysicalBookToList();
                        break;
                    case 2:
                        menu.addEBookToList();
                        break;
                    case 3:
                        menu.displayBookList();
                        break;
                    case 4:
                        menu.purchaseBooks();
                        break;
                    case 5:
                        menu.removeBookFromList();
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please try again.");
                scanner.nextLine(); // Clear the invalid input
            }
        }

        scanner.close();
    }
}

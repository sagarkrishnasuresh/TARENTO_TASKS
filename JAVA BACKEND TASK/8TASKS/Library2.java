import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String ISBN;
    private double price;
    private String genre;

    public Book(String title, String author, String ISBN, double price, String genre) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public double getPrice() {
        return price;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book [Title=" + title + ", Author=" + author + ", ISBN=" + ISBN + ", Price=" + price + ", Genre=" + genre + "]";
    }
}

public class Library {
    private ArrayList<Book> books;
    private HashSet<String> genres;

    public Library() {
        books = new ArrayList<>();
        genres = new HashSet<>();
    }

    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
        genres.add(book.getGenre()); // Add genre to the set
        System.out.println("Book added: " + book);
    }

    // Remove an existing book from the library by ISBN
    public void removeBook(String ISBN) {
        Book bookToRemove = null;
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Book removed: " + bookToRemove);
        } else {
            System.out.println("Book with ISBN " + ISBN + " not found.");
        }
    }

    // Display all books in the library
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // Display all unique genres in the library
    public void displayGenres() {
        if (genres.isEmpty()) {
            System.out.println("No genres available.");
        } else {
            System.out.println("Genres available in the library:");
            for (String genre : genres) {
                System.out.println(genre);
            }
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Display all books");
            System.out.println("4. Display all genres");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String ISBN = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    library.addBook(new Book(title, author, ISBN, price, genre));
                    break;
                case 2:
                    System.out.print("Enter ISBN of the book to remove: ");
                    String isbnToRemove = scanner.nextLine();
                    library.removeBook(isbnToRemove);
                    break;
                case 3:
                    library.displayBooks();
                    break;
                case 4:
                    library.displayGenres();
                    break;
                case 5:
                    System.out.println("Exiting the library system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

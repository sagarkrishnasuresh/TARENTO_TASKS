import java.util.HashMap;
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
    private HashMap<String, Book> books;
    private HashSet<String> genres;

    public Library() {
        books = new HashMap<>();
        genres = new HashSet<>();
    }

    // Add a new book to the library
    public void addBook(Book book) {
        books.put(book.getISBN(), book);
        genres.add(book.getGenre()); // Add genre to the set
        System.out.println("Book added: " + book);
    }

    // Update an existing book in the library by ISBN
    public void updateBook(String ISBN, Book updatedBook) {
        if (books.containsKey(ISBN)) {
            books.put(ISBN, updatedBook);
            genres.add(updatedBook.getGenre()); // Add or update genre
            System.out.println("Book updated: " + updatedBook);
        } else {
            System.out.println("Book with ISBN " + ISBN + " not found.");
        }
    }

    // Remove an existing book from the library by ISBN
    public void removeBook(String ISBN) {
        Book bookToRemove = books.remove(ISBN);
        if (bookToRemove != null) {
            System.out.println("Book removed: " + bookToRemove);
        } else {
            System.out.println("Book with ISBN " + ISBN + " not found.");
        }
    }

    // Retrieve and display a book by ISBN
    public void getBook(String ISBN) {
        Book book = books.get(ISBN);
        if (book != null) {
            System.out.println("Book found: " + book);
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
            for (Book book : books.values()) {
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
            System.out.println("2. Update a book");
            System.out.println("3. Remove a book");
            System.out.println("4. Retrieve a book by ISBN");
            System.out.println("5. Display all books");
            System.out.println("6. Display all genres");
            System.out.println("7. Exit");
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
                    System.out.print("Enter ISBN of the book to update: ");
                    String isbnToUpdate = scanner.nextLine();
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new genre: ");
                    String newGenre = scanner.nextLine();
                    library.updateBook(isbnToUpdate, new Book(newTitle, newAuthor, isbnToUpdate, newPrice, newGenre));
                    break;
                case 3:
                    System.out.print("Enter ISBN of the book to remove: ");
                    String isbnToRemove = scanner.nextLine();
                    library.removeBook(isbnToRemove);
                    break;
                case 4:
                    System.out.print("Enter ISBN of the book to retrieve: ");
                    String isbnToRetrieve = scanner.nextLine();
                    library.getBook(isbnToRetrieve);
                    break;
                case 5:
                    library.displayBooks();
                    break;
                case 6:
                    library.displayGenres();
                    break;
                case 7:
                    System.out.println("Exiting the library system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

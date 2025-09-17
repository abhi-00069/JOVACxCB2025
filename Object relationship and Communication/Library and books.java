import java.util.ArrayList;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void displayInfo() {
        System.out.println("Book: \"" + title + "\" by " + author);
    }
}

class Library {
    private String name;
    private ArrayList<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book); 
    }

    public void showLibraryBooks() {
        System.out.println("Library: " + name);
        for (Book book : books) {
            book.displayInfo();
        }
        System.out.println();
    }
}

public class AggregationDemo {
    public static void main(String[] args) {
        Book book1 = new Book("The Alchemist", "Paulo Coelho");
        Book book2 = new Book("Clean Code", "Robert C. Martin");
        Book book3 = new Book("Introduction to Algorithms", "Cormen et al.");

        Library cityLibrary = new Library("City Library");
        Library universityLibrary = new Library("University Library");

        cityLibrary.addBook(book1);
        cityLibrary.addBook(book2);

        universityLibrary.addBook(book2); 
        universityLibrary.addBook(book3);

        cityLibrary.showLibraryBooks();
        universityLibrary.showLibraryBooks();
    }
}

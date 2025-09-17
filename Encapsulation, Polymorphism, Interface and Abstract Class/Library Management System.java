interface Reservable {
    void reserveItem(String user);
    boolean checkAvailability();
}

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public abstract int getLoanDuration();

    public String getItemDetails() {
        return title + " by " + author + " (ID: " + itemId + ")";
    }
}

class Book extends LibraryItem implements Reservable {
    private boolean available = true;

    public Book(String id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 14;
    }

    public void reserveItem(String user) {
        available = false;
    }

    public boolean checkAvailability() {
        return available;
    }
}

class Magazine extends LibraryItem implements Reservable {
    private boolean available = true;

    public Magazine(String id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 7;
    }

    public void reserveItem(String user) {
        available = false;
    }

    public boolean checkAvailability() {
        return available;
    }
}

class DVD extends LibraryItem implements Reservable {
    private boolean available = true;

    public DVD(String id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 3;
    }

    public void reserveItem(String user) {
        available = false;
    }

    public boolean checkAvailability() {
        return available;
    }
}

public class LibraryDemo {
    public static void main(String[] args) {
        LibraryItem[] items = {
            new Book("B101", "Java Basics", "James Gosling"),
            new Magazine("M202", "Tech Today", "Editorial Team"),
            new DVD("D303", "Inception", "Christopher Nolan")
        };

        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            System.out.println("Available: " + ((Reservable) item).checkAvailability());
            ((Reservable) item).reserveItem("Abhishek");
            System.out.println("Available after reservation: " + ((Reservable) item).checkAvailability());
            System.out.println();
        }
    }
}

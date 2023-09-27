public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean available;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getISBN() {
        return isbn;
    }

 public String setISBN(String isbn) {
        this.isbn=isbn;
    }

    public String getTitle() {
        return title;
    }

   public String setTitle(String title) {
        this.title=title;
    }

    public String getAuthor() {
        return author;
    }
 public String setAuthor(String author) {
        this.author=author;
    }

    public boolean Availablity() {
        return available;
    }

    public void setAvailability(boolean availablity) {
       this.availability = availablity;
    }
}


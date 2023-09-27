import java.time.LocalDate;

public class Transaction {
    private String transactionId;
    private Book book;
    private Member member;
    private LocalDate barrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public Transaction(String transactionId, Book book, Member member, LocalDate barrowDate, LocalDate dueDate) {
        this.transactionId = transactionId;
        this.book = book;
        this.member = member;
        this.barrowDate = barrowDate;
        this.dueDate = dueDate;
    
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId=transactionId;
    }

    public Book getBook() {
        return book;
    }

   public void setBook(Book book) {
        this.book= book;
    }

    public Member getMember() {
        return member;
    }
    public void setMember(Member member) {
        this.member=member;
    }

    public LocalDate getBarrowDate() {
        return barrowDate;
    }
    public void setBarrowDate(LocalDate barrowDate) {
        this.barrowDate=barrowDate;
    }

     public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate=dueDate;
    }

     public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setReturenDate(LocalDate returnDate) {
        this.returnDate=returnDate;
    }

}



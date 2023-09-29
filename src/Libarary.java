import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  

public class Libarary {

    Book book1 = new Book("1", "Java", "James Gosling");
    Book book2 = new Book("2", "C++", "Bjarne Stroustrup");
    Book book3 = new Book("3", "Python", "Guido van Rossum");

    Member member1 = new Member("1", "John");
    Member member2 = new Member("2", "Mary");
    Member member3 = new Member("3", "Peter");

    Transaction transaction1 = new Transaction("1", book1, member1, LocalDate.now().minusDays(3), LocalDate.now().minusDays(2));
    Transaction transaction2 = new Transaction("2", book2, member2, LocalDate.now().minusDays(10), LocalDate.now().minusDays(8));

    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();

    public Libarary(){
        books.add(book1);
        books.add(book2);
        books.add(book3);

        members.add(member1);
        members.add(member2);
        members.add(member3);

        transactions.add(transaction1);
        transactions.add(transaction2);

    }


    public boolean addBook(Book book) {
        return books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public boolean removeBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }

     public boolean removeMember(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                members.remove(member);
                return true;
            }
        }
        return false;
    }

    public Book searchBook(String bookId) {
        for (Book book : books) {
            if (book.getIsbn().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

    public Member searchMember(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }

    public Transaction searchTransaction(String memberId) {
        for (Transaction transaction : transactions) {
            if (transaction.getMember().getMemberId().equals(memberId)) {
                return transaction;
            }
        }
        return null;
    }

    public List<String> displayBookNames(){
        List<String> bookNames = new ArrayList<>();
        for (Book book : books) {
            bookNames.add(book.getTitle());
        }
        return bookNames;
    }

    public List<String> displayMemberNames(){
        List<String> memberNames = new ArrayList<>();
        for (Member member : members) {
            memberNames.add(member.getName());
        }
        return memberNames;
    }

    public Transaction lendBook(Book book, Member member, LocalDate dueDate) {
        
        // today's date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate borrowedDate = LocalDate.now();
        book.setAvailability(false);

        Transaction transaction = new Transaction("1", book, member, borrowedDate, dueDate);

        transactions.add(transaction);
        return transaction;
    }

    public Transaction returnBook(String transactionId, LocalDate returndate) {
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionId().equals(transactionId)) {
                transaction.setReturnDate(returndate);
                transaction.getBook().setAvailability(true);

                //if overdued
                if (returndate.isAfter(transaction.getDueDate())) {
                    double fine = calculateFine(transaction);
                    System.out.println("Fine: " + fine);
                }
                return transaction;
            }
        }
        return null;
    }

    public void viewLendingInformation(Transaction Transaction) {
        if (Transaction.getReturnDate() == null) {
            System.out.println("Transaction ID: " + Transaction.getTransactionId());
            System.out.println("Book: " + Transaction.getBook().getTitle());
            System.out.println("Member: " + Transaction.getMember().getName());
            System.out.println("Borrowed Date: " + Transaction.getBorrowedDate());
            System.out.println("Due Date: " + Transaction.getDueDate());
            System.out.println("Return Date: " + Transaction.getReturnDate());
        }else{
            System.out.println("No books to be returned");
        }
    }

    public void displayOverDueBooks(){
        for (Transaction transaction : transactions) {
            if (transaction.getReturnDate() == null && LocalDate.now().isAfter(transaction.getDueDate())) {
                System.out.println("Transaction ID: " + transaction.getTransactionId());
                System.out.println("Book: " + transaction.getBook().getTitle());
                System.out.println("Member: " + transaction.getMember().getName());
                System.out.println("Borrowed Date: " + transaction.getBorrowedDate());
                System.out.println("Due Date: " + transaction.getDueDate() + "\n");
            }
        }
    }

    public double calculateFine(Transaction transaction){
        //Rs. 50 per additional day for up to 7 days and Rs. 100 per additional day after 7 days
        
        double fine = 0;
        int days = 0;
        try {
            days = transaction.getReturnDate().getDayOfYear() - transaction.getDueDate().getDayOfYear();
        } catch (Exception e) {
            System.out.println("Book not returned yet!");
        }

        if (days > 7) {
            fine = (days - 7) * 100;
        } else if (days > 0) {
            fine = days * 50;
        }

        return fine;
    }
}

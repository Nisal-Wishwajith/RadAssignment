import java.util.*;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  

public class Libarary {
    private List<Book> books;
    private List<Member> members;
    private List<Transaction> transactions;


    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void removeMember(Member member) {
        members.remove(member);
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

    public Transaction lendBook(Book book, Member member, Date dueDate) {
        
        // today's date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String borrowedDate = dtf.format(java.time.LocalDateTime.now());
        String dueDate = dtf.format(java.time.LocalDateTime.now().plusDays(7));
        Transaction transaction = new Transaction(book, member, borrowedDate, dueDate);
        transactions.add(transaction);
        return transaction;
    }

    public Transaction returnBook(String transactionId, Date returndate) {
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionId().equals(transactionId)) {
                transaction.setReturnDate(returndate);
                return transaction;
            }
        }
        return null;
    }

    public void viewLendingInformation(Transaction Transaction) {
        System.out.println("Transaction ID: " + Transaction.getTransactionId());
        System.out.println("Book: " + Transaction.getBook().getTitle());
        System.out.println("Member: " + Transaction.getMember().getName());
        System.out.println("Borrowed Date: " + Transaction.getBorrowedDate());
        System.out.println("Due Date: " + Transaction.getDueDate());
        System.out.println("Return Date: " + Transaction.getReturnDate());
    }

    public void displayOverDueBooks(List transtactions){
        for (Transaction transaction : transactions) {
            if (transaction.getReturnDate() == null) {
                System.out.println("Transaction ID: " + transaction.getTransactionId());
                System.out.println("Book: " + transaction.getBook().getTitle());
                System.out.println("Member: " + transaction.getMember().getName());
                System.out.println("Borrowed Date: " + transaction.getBorrowedDate());
                System.out.println("Due Date: " + transaction.getDueDate());
            }
        }
    }

    public double calculateFine(Transaction transaction, String returnDate){
        double fine = 0;
        if (transaction.getReturnDate() == null) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String today = dtf.format(java.time.LocalDateTime.now());
            int days = today - transaction.getDueDate();
            fine = days * 0.5;
        }
        return fine;
    }
}

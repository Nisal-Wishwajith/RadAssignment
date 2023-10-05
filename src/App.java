import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Libarary library = new Libarary();
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        
        do {

            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Register Member");
            System.out.println("4. Remove Member");
            System.out.println("5. Search Book Information");
            System.out.println("6. Search Member Information");
            System.out.println("7. Display Book Names");
            System.out.println("8. Display Member Names");
            System.out.println("9. Lend books");
            System.out.println("10. Return books");
            System.out.println("11. View Lending Information");
            System.out.println("12. Display Overdue books");
            System.out.println("13. Fine Calculation");
            System.out.println("14. Exit");
            System.out.print("Enter your choice: ");

            input = scanner.nextInt();

            Scanner sc = new Scanner(System.in);
            switch (input) {
                case 1://add book
                    System.out.println("Enter book isbn: ");
                    String isbn = sc.nextLine();
                    System.out.print("Enter book title: ");
                    String bookTitle = sc.nextLine();
                    System.out.print("Enter book author: ");
                    String author = sc.nextLine();

                    Book newBook = new Book(isbn, bookTitle, author);
                    library.addBook(newBook);
                    System.out.println("Book added successfully!");
                    break;
                case 2:// remove book
                    System.out.print("Enter book ISBN to remove: ");
                    isbn = sc.nextLine();
                    library.removeBook(isbn);
                    System.out.println("Book removed successfully!");
                    break;
                case 3:// add member
                    System.out.print("Enter member ID: ");
                    String memberId = sc.nextLine();
                    System.out.print("Enter member name: ");
                    String memberName = sc.nextLine();
                    Member newMember = new Member(memberId, memberName);
                    library.addMember(newMember);
                    System.out.println("Member registered successfully!");
                    break;
                case 4:// remove member
                    System.out.print("Enter member ID to remove: ");
                    String memberIdToRemove = sc.nextLine();
                    library.removeMember(memberIdToRemove);
                    System.out.println("Member removed successfully!");
                    break;
                case 5:// search book
                    System.out.print("Enter book Title to search: ");
                    String bookTitleToSearch = sc.nextLine();
                    Book foundBook = library.searchBook(bookTitleToSearch);
                    if (foundBook != null) {
                        System.out.println("Book ID: " + foundBook.getIsbn());
                        System.out.println("Book Title: " + foundBook.getTitle());
                        System.out.println("Book Author: " + foundBook.getAuthor());
                        System.out.println("Availability: " + (foundBook.isAvailable() ? "Available" : "Not Available"));
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 6:// search member     
                    System.out.print("Enter member ID to search: ");
                    String memberIdToSearch = sc.nextLine();
                    Member foundMember = library.searchMember(memberIdToSearch);
                    if (foundMember != null) {
                        System.out.println("Member ID: " + foundMember.getMemberId());
                        System.out.println("Member Name: " + foundMember.getName());
                        System.out.print("Borrowed Books: ");
                        for (Book book : foundMember.getbookBorrowed()) {
                            System.out.print(book.getTitle() + ", ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;
                case 7:// display book names
                    List<String> bookNames = library.displayBookNames();
                    for (String bookName : bookNames) {
                        System.out.println(bookName);
                    }
                    break;
                case 8:// display member names
                    List<String> memberNames = library.displayMemberNames();
                    for (String membername : memberNames) {
                        System.out.println(membername);
                    }
                    break;
                
                case 9:// lend book
                    System.out.print("Enter member ID: ");
                    memberIdToSearch = sc.nextLine();
                    foundMember = library.searchMember(memberIdToSearch);

                    System.out.print("Enter book Title: ");
                    bookTitleToSearch = sc.nextLine();
                    foundBook = library.searchBook(bookTitleToSearch);

                    

                    LocalDate duDate = LocalDate.now().plusDays(14);
                    library.lendBook(foundBook, foundMember, duDate);

                    break;

                case 10:// return book
                    System.out.print("Enter member ID: ");
                    memberIdToSearch = sc.nextLine();
                    foundMember = library.searchMember(memberIdToSearch);

                    System.out.print("Enter book Title: ");
                    bookTitleToSearch = sc.nextLine();
                    foundBook = library.searchBook(bookTitleToSearch);

                    Transaction transaction = library.searchTransaction(foundMember.getMemberId(), foundBook.getIsbn());
                    
                    LocalDate returnDate = LocalDate.now();
                    String transactionId = transaction.getTransactionId();

                    if (library.returnBook(transactionId, returnDate) != null) {
                        System.out.println("Book returned successfully!");
                    }

                    break;
                
                case 11://  view lending information of book
                    System.out.print("Enter Book Title : ");
                    bookTitleToSearch = sc.nextLine();

                    foundBook = library.searchBook(bookTitleToSearch);

                    transaction = library.searchTransaction(foundBook.getIsbn());
                    library.viewLendingInformation(transaction);
                    break;
                
                case 12: // display overdue books
                    library.displayOverDueBooks();
                    break;

                case 13: // fine calculation
                    System.out.print("Enter member ID: ");
                    String memberIdToFine = sc.nextLine();

                    transaction = library.searchTransaction(memberIdToFine);
                    double fine = library.calculateFine(transaction);
                    System.out.println("Fine: " + fine);
                    break;
                
                case 14: // exit
                    System.out.println("Thank you for using the Library Management System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;  
            }
        } while (input != 14);

        scanner.close();
        
    }
}

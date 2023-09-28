import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Libarary library = new Libarary();
        Scanner scanner = new Scanner(System.in);
        int input;
        // String isbn;
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
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            input = scanner.nextInt();

            Scanner sc = new Scanner(System.in);
            switch (input) {
                case 1:
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
                case 2:
                    System.out.print("Enter book ISBN to remove: ");
                    isbn = sc.nextLine();
                    library.removeBook(isbn);
                    System.out.println("Book removed successfully!");
                    break;
                case 3:
                    System.out.print("Enter member ID: ");
                    String memberId = sc.nextLine();
                    System.out.print("Enter member name: ");
                    String memberName = sc.nextLine();
                    Member newMember = new Member(memberId, memberName);
                    library.addMember(newMember);
                    System.out.println("Member registered successfully!");
                    break;
                case 4:
                    System.out.print("Enter member ID to remove: ");
                    String memberIdToRemove = sc.nextLine();
                    library.removeMember(memberIdToRemove);
                    System.out.println("Member removed successfully!");
                    break;
                case 5:
                    System.out.print("Enter book ISBN to search: ");
                    String bookIdToSearch = sc.nextLine();
                    Book foundBook = library.searchBook(bookIdToSearch);
                    if (foundBook != null) {
                        System.out.println("Book ID: " + foundBook.getIsbn());
                        System.out.println("Book Title: " + foundBook.getTitle());
                        System.out
                                .println("Availability: " + (foundBook.isAvailable() ? "Available" : "Not Available"));
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter member ID to search: ");
                    String memberIdToSearch = sc.nextLine();
                    Member foundMember = library.searchMember(memberIdToSearch);
                    if (foundMember != null) {
                        System.out.println("Member ID: " + foundMember.getMemberId());
                        System.out.println("Member Name: " + foundMember.getName());
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;
                case 7:
                    library.displayBookNames();
                    break;
                case 8:
                    library.displayMemberNames();
                    break;
                case 9:
                    System.out.println("Exiting Library Management System.");
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (input == 9);

        scanner.close();
    }
}

import java.util.*;

public class Member {
    private String memberId;
    private String name;
    private List<Book> booksBorrowed;

    public Member(String MemberID, String MemberName) {
        this.memberId = MemberID;
        this.name = MemberName;
        this.booksBorrowed = new ArrayList<Book>();
        
    }

    // getter and setter for MemberID
    public String getMemberId() {
        return this.memberId;
    }

    public void setMemberId(String NewMemberId) {
        this.memberId = NewMemberId;
    }

    // getter and setter for Member's Name
    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    // getter and setter for bookBorrowed
    public List<Book> getbookBorrowed() {
        return this.booksBorrowed;
    }

    public void setbookBorrowed(List<Book> newbookBorrowed) {
        this.booksBorrowed = newbookBorrowed;
    }
}

package main.java.org.lldProblemStatements.LibraryManagementSystem;

public class BookBorrow {
    private Book book;
    private Member member;
    private long borrowingDate;
    private long returnDate;
    private static final int BORROW_COST_PER_DAY = 10;

    public BookBorrow(Book book, Member member){
        this.book = book;
        this.member = member;
        borrowingDate = 999999899;
    }

    public void pay(){
        this.returnDate = 999999999;
        final int finalAmount = (int)(returnDate-borrowingDate)*BORROW_COST_PER_DAY;

        System.out.println("Redirecting you to payment page");
        System.out.println("Payment successful of "+finalAmount);
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public long getBorrowingDate() {
        return borrowingDate;
    }

    public long getReturnDate() {
        return returnDate;
    }
}

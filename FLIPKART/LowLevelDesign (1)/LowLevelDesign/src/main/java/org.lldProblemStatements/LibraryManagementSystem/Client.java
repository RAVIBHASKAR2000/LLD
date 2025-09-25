package main.java.org.lldProblemStatements.LibraryManagementSystem;

import java.util.*;

public class Client {
    public static void main(String[] args){
        Book book1 = new Book("Godaan");
        Book book2 = new Book("Fault in Our Stars");
        Book book3 = new Book("Angles and Demons");

        Member mem1 = new Member("Akshay");

        Librarian lib1 = new Librarian();
        List<Librarian> librarians = new ArrayList<>();
        librarians.add(lib1);

        LibraryContext library = new LibraryContext(librarians);

        BookBorrow borrow = library.lendBook(lib1,mem1,book2);

        library.returnBook(lib1,borrow);
    }
}

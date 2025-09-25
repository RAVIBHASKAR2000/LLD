package main.java.org.lldProblemStatements.LibraryManagementSystem;

import java.util.*;

public class Member {
    private String name;
    private List<Book> borrowedBooks;

    public Member(String name){
        this.name = name;
        borrowedBooks = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public void borrowBook(Book book){
        borrowedBooks.add(book);
    }

    public void returnBook(Book book){
        borrowedBooks.remove(book);
    }
}

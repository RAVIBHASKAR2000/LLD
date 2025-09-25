package main.java.org.lldProblemStatements.LibraryManagementSystem;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class LibraryContext {
    private List<Member> members;
    private List<Librarian> librarians;
    private List<Book> books;
    private HashSet<BookBorrow> activeBorrowedBooks;

    public LibraryContext(List<Librarian> lib){
        members = new ArrayList<>();
        librarians = lib;
        books = new ArrayList<>();
        activeBorrowedBooks = new HashSet<>();
    }

    public synchronized void addBook(@NotNull Librarian librarian, Book book){
        if(isValidLibrarian(librarian)){
            books.add(book);
            System.out.println("Added a new book: "+book.getName());
        }
    }

    public synchronized void removeBook(@NotNull Librarian librarian, Book book){
        if(isValidLibrarian(librarian)) {
            books.remove(book);
            System.out.println("Removed book: " + book.getName());
        }
    }

    public void addMember(@NotNull Librarian librarian, Member member){
        if(isValidLibrarian(librarian)) {
            members.add(member);
            System.out.println("Added a new member: " + member.getName());
        }
    }

    public void removeMember(@NotNull Librarian librarian, Member member){
        if(isValidLibrarian(librarian)) {
            members.remove(member);
            System.out.println("Removed member: " + member.getName());
        }
    }

    public synchronized BookBorrow lendBook(Librarian librarian, Member member, Book book){
        if(isValidLibrarian(librarian)) {
            // remove book from books array
            books.remove(book);
            // add borrow obj to the activeBorrowedBooks
            BookBorrow borrow = new BookBorrow(book, member);
            activeBorrowedBooks.add(borrow);
            // add it to member's list
            member.borrowBook(book);
            return borrow;
        }
        return null;
    }

    private boolean isValidLibrarian(Librarian librarian){
        return librarians.contains(librarian);
    }

    public synchronized void returnBook(Librarian librarian, BookBorrow borrow){
        if(isValidLibrarian(librarian)) {
            // pay the final amount
            borrow.pay();
            // return the book to the library shelves
            books.add(borrow.getBook());
            // remove the borrow from active hashset
            activeBorrowedBooks.remove(borrow);
            borrow.getMember().returnBook(borrow.getBook());
        }
    }

    public Book searchBook(Book book){
        return books.get(2);
    }



}

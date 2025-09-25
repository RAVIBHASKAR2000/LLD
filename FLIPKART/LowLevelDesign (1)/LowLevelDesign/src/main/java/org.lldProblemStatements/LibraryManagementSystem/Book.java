package main.java.org.lldProblemStatements.LibraryManagementSystem;

public class Book {
    private String name;
    private boolean isAvailable;
    private Member borrowedBy;

    public Book(String name){
        this.name = name;
        this.isAvailable = true;
    }

    public boolean isAvailable(){
        return this.isAvailable;
    }

    public void setUnavailable(){
        this.isAvailable = false;
    }

    public String getName() {
        return name;
    }
}

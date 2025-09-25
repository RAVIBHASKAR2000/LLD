package main.java.org.lldProblemStatements.bookMyShow.models;

public interface Payment {
    boolean pay(double amount, User user);
}

class UPIPayment implements Payment{
    @Override
    public boolean pay(double amount, User user){
        // pay via UPI
        return true;
    }
}
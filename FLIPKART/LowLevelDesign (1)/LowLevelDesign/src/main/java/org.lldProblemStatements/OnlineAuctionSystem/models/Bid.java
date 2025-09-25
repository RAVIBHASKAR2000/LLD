package main.java.org.lldProblemStatements.OnlineAuctionSystem.models;

public class Bid {
    private Buyer buyer;
    private Auction auction;
    private double amount;
    private boolean isWithdrawn;

    public Bid(Buyer buyer, Auction auction, double amount) {
        this.buyer = buyer;
        this.auction = auction;
        this.amount = amount;
        this.isWithdrawn = false;
    }

    public Buyer getBuyer() { return buyer; }
    public Auction getAuction() { return auction; }
    public double getAmount() { return amount; }
    public boolean isWithdrawn() { return isWithdrawn; }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void withdraw() {
        this.isWithdrawn = true;
    }
}


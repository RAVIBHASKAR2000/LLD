package main.java.org.lldProblemStatements.OnlineAuctionSystem.models;

import java.util.ArrayList;
import java.util.List;

public class Seller extends User {
    private List<Auction> auctionsCreated;

    public Seller(String id, String name) {
        super(id, name);
        this.auctionsCreated = new ArrayList<>();
    }

    public List<Auction> getAuctionsCreated() {
        return auctionsCreated;
    }

    public void addAuction(Auction auction) {
        auctionsCreated.add(auction);
    }
}


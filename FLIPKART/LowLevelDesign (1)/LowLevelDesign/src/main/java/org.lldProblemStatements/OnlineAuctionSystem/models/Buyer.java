package main.java.org.lldProblemStatements.OnlineAuctionSystem.models;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends User {
    private List<Bid> bids;

    public Buyer(String id, String name) {
        super(id, name);
        this.bids = new ArrayList<>();
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void addBid(Bid bid) {
        bids.add(bid);
    }
}


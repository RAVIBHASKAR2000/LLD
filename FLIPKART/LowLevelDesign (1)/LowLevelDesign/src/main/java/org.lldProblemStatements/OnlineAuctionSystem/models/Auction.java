package main.java.org.lldProblemStatements.OnlineAuctionSystem.models;

import java.util.*;


public class Auction {
    private String id;
    // think of synchronisation here
    private double lowestBidLimit;
    private double highestBidLimit;
    private double participationCost;
    private Seller seller;
    private boolean isClosed;

    private Set<Bid> bids;
    private Set<Buyer> participants;

    public Auction(String id, double lowestBidLimit, double highestBidLimit,
                   double participationCost, Seller seller) {
        this.id = id;
        this.lowestBidLimit = lowestBidLimit;
        this.highestBidLimit = highestBidLimit;
        this.participationCost = participationCost;
        this.seller = seller;
        this.bids = new HashSet<>();
        this.participants = new HashSet<>();
        this.isClosed = false;
    }

    public String getId() { return id; }
    public double getLowestBidLimit() { return lowestBidLimit; }
    public double getHighestBidLimit() { return highestBidLimit; }
    public double getParticipationCost() { return participationCost; }
    public Seller getSeller() { return seller; }
    public boolean isClosed() { return isClosed; }

    public Set<Bid> getBids() { return bids; }
    public Set<Buyer> getParticipants() { return participants; }

    public void addParticipant(Buyer buyer) {
        participants.add(buyer);
    }

    public void addBid(Bid bid) {
        bids.add(bid);
    }

    public void closeAuction() {
        isClosed = true;
    }
}

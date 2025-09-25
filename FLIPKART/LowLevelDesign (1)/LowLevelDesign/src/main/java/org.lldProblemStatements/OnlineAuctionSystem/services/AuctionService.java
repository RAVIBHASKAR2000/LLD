package main.java.org.lldProblemStatements.OnlineAuctionSystem.services;

import main.java.org.lldProblemStatements.OnlineAuctionSystem.models.Auction;
import main.java.org.lldProblemStatements.OnlineAuctionSystem.models.Seller;
import main.java.org.lldProblemStatements.OnlineAuctionSystem.models.Buyer;
import main.java.org.lldProblemStatements.OnlineAuctionSystem.models.Bid;
import main.java.org.lldProblemStatements.OnlineAuctionSystem.models.AuctionResult;

import java.util.*;


public class AuctionService {
    private static AuctionService instance;
    private UserService userService;
    private Map<String, Auction> auctions;

    private AuctionService() {
        this.userService = UserService.getInstance();
        this.auctions = new HashMap<>();
    }

    public static synchronized AuctionService getInstance() {
        if (instance == null) {
            instance = new AuctionService();
        }
        return instance;
    }

    public Auction createAuction(String id, double lowLimit, double highLimit, double participationCost, String sellerId) {
        Seller seller = userService.getSellerById(sellerId);
        if (seller == null) throw new IllegalArgumentException("Seller not found");

        Auction auction = new Auction(id, lowLimit, highLimit, participationCost, seller);
        auctions.put(id, auction);
        seller.addAuction(auction);
        return auction;
    }

    public void placeOrUpdateBid(String auctionId, String buyerId, double amount) {
        Auction auction = auctions.get(auctionId);
        Buyer buyer = userService.getBuyerById(buyerId);

            if (auction == null || buyer == null || auction.isClosed()) return;

        boolean alreadyParticipating = auction.getParticipants().contains(buyer);
        if (!alreadyParticipating) {
            auction.addParticipant(buyer);
        }
        Bid b = null;
        for(Bid bid:auction.getBids()){
            if(bid.getBuyer().getId().equals(buyer.getId())){
                b = bid;
                break;
            }
        }
        if(b==null){
            b = new Bid(buyer,auction,amount);
            auction.addBid(b);
        }
        else{
            b.setAmount(amount);
        }
    }

    public void withdrawBid(String auctionId, String buyerId) {
        Auction auction = auctions.get(auctionId);
        Buyer buyer = userService.getBuyerById(buyerId);

        if (auction == null || buyer == null || auction.isClosed()) return;

        auction.getBids().stream()
                .filter(b -> b.getBuyer().equals(buyer) && !b.isWithdrawn())
                .forEach(Bid::withdraw);
    }

    public AuctionResult closeAuction(String auctionId) {
        Auction auction = auctions.get(auctionId);
        if (auction == null || auction.isClosed()) return null;

        auction.closeAuction();

        List<Bid> validBids = auction.getBids().stream().filter(b->!b.isWithdrawn()).toList();

        Map<Double, Integer> bidCount = new HashMap<>();
        for (Bid bid : validBids) {
            bidCount.put(bid.getAmount(), bidCount.getOrDefault(bid.getAmount(), 0) + 1);
        }

        double highestUnique = -1;
        for (Double amount : bidCount.keySet()) {
            if (bidCount.get(amount) == 1 && amount > highestUnique) {
                highestUnique = amount;
            }
        }

        Bid winningBid = null;
        if (highestUnique != -1) {
            for (Bid bid : validBids) {
                if (bid.getAmount() == highestUnique) {
                    winningBid = bid;
                    break;
                }
            }
        }

        int participants = auction.getParticipants().size();
        double sellerShare = 0.2 * auction.getParticipationCost() * participants;
        double averageBidLimit = (auction.getLowestBidLimit() + auction.getHighestBidLimit()) / 2;
        double profitOrLoss = sellerShare;

        if (winningBid != null) {
            profitOrLoss += winningBid.getAmount() - averageBidLimit;
        }

        return new AuctionResult(winningBid, profitOrLoss);
    }

    public Auction getAuction(String auctionId) {
        return auctions.get(auctionId);
    }
}


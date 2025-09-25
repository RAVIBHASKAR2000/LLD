package main.java.org.lldProblemStatements.OnlineAuctionSystem.models;

public class AuctionResult {
    private Bid winningBid;
    private double sellerProfitOrLoss;

    public AuctionResult(Bid winningBid, double sellerProfitOrLoss) {
        this.winningBid = winningBid;
        this.sellerProfitOrLoss = sellerProfitOrLoss;
    }

    public Bid getWinningBid() { return winningBid; }
    public double getSellerProfitOrLoss() { return sellerProfitOrLoss; }
}


package main.java.org.lldProblemStatements.OnlineAuctionSystem;


import main.java.org.lldProblemStatements.OnlineAuctionSystem.models.AuctionResult;
import main.java.org.lldProblemStatements.OnlineAuctionSystem.services.AuctionService;
import main.java.org.lldProblemStatements.OnlineAuctionSystem.services.UserService;

public class Client {
    public static void main(String[] args) {
        UserService userService = UserService.getInstance();
        AuctionService auctionService = AuctionService.getInstance();

        userService.addBuyer("buyer1", "Buyer One");
        userService.addBuyer("buyer2", "Buyer Two");
        userService.addBuyer("buyer3", "Buyer Three");


        userService.addSeller("seller1", "Seller One");


        auctionService.createAuction("A1", 10, 50, 1, "seller1");


        auctionService.placeOrUpdateBid("A1", "buyer1", 17);   // Unique
        auctionService.placeOrUpdateBid("A1", "buyer2", 15);
        auctionService.placeOrUpdateBid("A1", "buyer2", 19);
        auctionService.placeOrUpdateBid("A1", "buyer3", 19);   // 19 becomes duplicate


        AuctionResult result1 = auctionService.closeAuction("A1");

        if (result1.getWinningBid() != null) {
            System.out.println("Winner for A1: " + result1.getWinningBid().getBuyer().getName());
        } else {
            System.out.println("No winner for A1.");
        }

        System.out.printf("Profit/Loss for Seller1: %.2f%n", result1.getSellerProfitOrLoss());


        // Add another Seller
        userService.addSeller("seller2", "Seller Two");

        // Create Auction A2
        auctionService.createAuction("A2", 5, 20, 2, "seller2");

        // Invalid bid (exceeds upper limit)
        try {
            auctionService.placeOrUpdateBid("A2", "buyer3", 25); // Should be ignored or silently fail
            System.out.println("Invalid bid was incorrectly accepted.");
        } catch (Exception e) {
            System.out.println("Bid of 25 rejected: exceeds upper limit.");
        }

        // Valid bid and withdrawal
        auctionService.placeOrUpdateBid("A2", "buyer2", 5);
        auctionService.withdrawBid("A2", "buyer2");

        // Close Auction
        AuctionResult result2 = auctionService.closeAuction("A2");

        if (result2.getWinningBid() != null) {
            System.out.println("Winner for A2: " + result2.getWinningBid().getBuyer().getName());
        } else {
            System.out.println("No winner for A2.");
        }

        System.out.printf("Profit/Loss for Seller2: %.2f%n", result2.getSellerProfitOrLoss());
    }
}

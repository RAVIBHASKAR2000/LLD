package repository;

import dto.Auction;

import java.util.ArrayList;
import java.util.List;

public class AuctionRepository {
    static List<Auction> auctionList;



    public AuctionRepository() {
        auctionList =new ArrayList<>();
    }

    public static List<Auction> getAuctionList() {
        return auctionList;
    }

}

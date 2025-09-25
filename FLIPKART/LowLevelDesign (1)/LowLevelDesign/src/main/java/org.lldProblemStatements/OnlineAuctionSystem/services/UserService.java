package main.java.org.lldProblemStatements.OnlineAuctionSystem.services;

import main.java.org.lldProblemStatements.OnlineAuctionSystem.models.Buyer;
import main.java.org.lldProblemStatements.OnlineAuctionSystem.models.Seller;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private static UserService instance;

    private Map<String, Buyer> buyers;
    private Map<String, Seller> sellers;

    private UserService() {
        buyers = new HashMap<>();
        sellers = new HashMap<>();
    }

    public static synchronized UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public Buyer addBuyer(String id, String name) {
        if (buyers.containsKey(id)) return buyers.get(id);
        Buyer buyer = new Buyer(id, name);
        buyers.put(id, buyer);
        return buyer;
    }

    public Seller addSeller(String id, String name) {
        if (sellers.containsKey(id)) return sellers.get(id);
        Seller seller = new Seller(id, name);
        sellers.put(id, seller);
        return seller;
    }

    public Buyer getBuyerById(String id) {
        return buyers.get(id);
    }

    public Seller getSellerById(String id) {
        return sellers.get(id);
    }
}


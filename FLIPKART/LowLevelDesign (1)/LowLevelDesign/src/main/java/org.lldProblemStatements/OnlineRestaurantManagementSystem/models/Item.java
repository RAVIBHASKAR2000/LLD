package main.java.org.lldProblemStatements.OnlineRestaurantManagementSystem.models;

public class Item {
    private String ItemName;
    private double price;

    public Item(String itemName, double price) {
        ItemName = itemName;
        this.price = price;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}

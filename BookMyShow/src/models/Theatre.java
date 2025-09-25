package models;
import  java.util.*;

public  class Theatre {
    private String theatreId;
    private String theatreName;
    private int totalScreens;
    private List<String> facilities;
    private String contactNumber;
    private Address address;
    private City city;
    private List<Screen> screens;

    public Theatre(String theatreId, String theatreName, City city, Address address, String contactNumber) {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.city = city;
        this.address = address;
        this.contactNumber = contactNumber;
        this.facilities = new ArrayList<>();
        this.screens = new ArrayList<>();
        this.totalScreens = 0;
    }

    public void addScreen(Screen screen) {
        screens.add(screen);
        totalScreens++;
    }

    // Getters
    public String getTheatreId() { return theatreId; }
    public String getTheatreName() { return theatreName; }
    public List<Screen> getScreens() { return screens; }
    public City getCity() { return city; }
}
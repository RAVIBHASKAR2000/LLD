package main.java.com.Flipkart.model;

public class Booking {
    private static int counter = 1000;

    private String bookingId;
    private String username;
    private String showName;
    private String slotTime;
    private int numPersons;
    private boolean fromWaitlist;

    public Booking(String username, String showName, String slotTime, int numPersons) {
        this.bookingId = String.valueOf(counter++);
        this.username = username;
        this.showName = showName;
        this.slotTime = slotTime;
        this.numPersons = numPersons;
        this.fromWaitlist = false;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getUsername() {
        return username;
    }

    public String getShowName() {
        return showName;
    }

    public String getSlotTime() {
        return slotTime;
    }

    public int getNumPersons() {
        return numPersons;
    }

    public boolean isFromWaitlist() {
        return fromWaitlist;
    }

    public void markFromWaitlist() {
        this.fromWaitlist = true;
    }
}
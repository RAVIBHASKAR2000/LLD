package main.java.com.Flipkart.model;
import java.util.*;

public class ShowSlot {
    private String slotTime; // "09:00-10:00"
    private int capacity;
    private int booked;
    private Queue<Booking> waitList;

    public ShowSlot(String slotTime, int capacity) {
        this.slotTime = slotTime;
        this.capacity = capacity;
        this.booked = 0;
        this.waitList = new LinkedList<>();
    }

    public String getSlotTime() {
        return slotTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getBooked() {
        return booked;
    }

    public int getAvailable() {
        return capacity - booked;
    }

    public boolean book(int numPeople) {
        if (numPeople <= getAvailable()) {
            booked += numPeople;
            return true;
        }
        return false;
    }

    public void cancel(int numPeople) {
        booked -= numPeople;
    }

    public Queue<Booking> getWaitList() {
        return waitList;
    }
}
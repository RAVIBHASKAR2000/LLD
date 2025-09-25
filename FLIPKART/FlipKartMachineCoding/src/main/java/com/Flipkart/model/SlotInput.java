package main.java.com.Flipkart.model;

public class SlotInput {
    private String timeRange;
    private int capacity;

    public SlotInput(String timeRange, int capacity) {
        this.timeRange = timeRange;
        this.capacity = capacity;
    }

    public String getTimeRange() {
        return timeRange;
    }

    public int getCapacity() {
        return capacity;
    }
}

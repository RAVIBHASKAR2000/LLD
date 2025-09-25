package models;
import java.time.LocalDateTime;
import  java.util.*;

public class SeatHold {
    private String holdId;
    private String userId;
    private List<Seat> seats;
    private Show show;
    private LocalDateTime holdTime;
    private LocalDateTime expiryTime;
    private boolean isActive;

    public SeatHold(String holdId, String userId, Show show, List<Seat> seats) {
        this.holdId = holdId;
        this.userId = userId;
        this.show = show;
        this.seats = seats;
        this.holdTime = LocalDateTime.now();
        this.expiryTime = holdTime.plusMinutes(15); // 15 minute hold
        this.isActive = true;
    }

    public boolean extendHold() {
        if (isActive && LocalDateTime.now().isBefore(expiryTime)) {
            expiryTime = expiryTime.plusMinutes(5);
            return true;
        }
        return false;
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiryTime);
    }

    // Getters
    public String getHoldId() { return holdId; }
    public String getUserId() { return userId; }
    public List<Seat> getSeats() { return seats; }
    public Show getShow() { return show; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { this.isActive = active; }
}


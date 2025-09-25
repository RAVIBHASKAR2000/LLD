package models;
import java.util.*;

public class Screen {
    private String screenId;
    private String screenName;
    private int totalSeats;
    private String screenType;
    private List<Seat> seats;
    private List<Show> shows;

    public Screen(String screenId, String screenName, String screenType, int totalSeats) {
        this.screenId = screenId;
        this.screenName = screenName;
        this.screenType = screenType;
        this.totalSeats = totalSeats;
        this.seats = new ArrayList<>();
        this.shows = new ArrayList<>();
    }

    public List<Seat> getAvailableSeats(String showId) {
        return seats.stream()
                .filter(seat -> seat.getStatus() == SeatStatus.AVAILABLE)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public void updateSeatStatus(String seatId, SeatStatus status) {
        seats.stream()
                .filter(seat -> seat.getSeatId().equals(seatId))
                .findFirst()
                .ifPresent(seat -> seat.setStatus(status));
    }

    public void addShow(Show show) {
        shows.add(show);
    }

    // Getters
    public String getScreenId() { return screenId; }
    public String getScreenName() { return screenName; }
    public List<Show> getShows() { return shows; }
    public List<Seat> getSeats() { return seats; }

    public int getTotalSeats() {
        return totalSeats;
    }
}

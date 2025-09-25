package models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Show {
    private String showId;
    private Movie movie;
    private Screen screen;
    private LocalDate showDate;
    private LocalTime showTime;
    private double price;
    private int availableSeats;

    public Show(String showId, Movie movie, Screen screen, LocalDate showDate, LocalTime showTime, double price) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.showDate = showDate;
        this.showTime = showTime;
        this.price = price;
        this.availableSeats = screen.getTotalSeats();
    }

    public boolean bookSeats(int numberOfSeats) {
        if (availableSeats >= numberOfSeats) {
            availableSeats -= numberOfSeats;
            return true;
        }
        return false;
    }

    // Getters
    public String getShowId() { return showId; }
    public Movie getMovie() { return movie; }
    public Screen getScreen() { return screen; }
    public LocalDate getShowDate() { return showDate; }
    public LocalTime getShowTime() { return showTime; }
    public double getPrice() { return price; }
    public int getAvailableSeats() { return availableSeats; }
}

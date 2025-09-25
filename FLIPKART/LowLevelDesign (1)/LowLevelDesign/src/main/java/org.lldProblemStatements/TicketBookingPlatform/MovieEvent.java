package main.java.org.lldProblemStatements.TicketBookingPlatform;

public class MovieEvent implements Event{
    private String epochEventTime;
    private int durationOfEvent; // in hours
    private boolean isOver;
    private String movieName;

    public MovieEvent(String epochEventTime, int durationOfEvent, String movieName) {
        this.epochEventTime = epochEventTime;
        this.durationOfEvent = durationOfEvent;
        this.movieName = movieName;
        this.isOver = false;
    }

    public void markOver(){
        this.isOver = true;
    }

}

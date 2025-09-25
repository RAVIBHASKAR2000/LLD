package service;
import models.*;

import java.time.LocalDate;
import  java.util.*;
public class ShowService {
    private Map<String, Show> shows;

    public ShowService() {
        this.shows = new HashMap<>();
    }

    public void addShow(Show show) {
        shows.put(show.getShowId(), show);
        show.getScreen().addShow(show);
        System.out.println("Show added: " + show.getMovie().getTitle() + " at " + show.getShowTime());
    }

    public void removeShow(String showId) {
        Show removed = shows.remove(showId);
        if (removed != null) {
            System.out.println("Show removed: " + removed.getShowId());
        }
    }

    public List<Show> searchShows(String movieId, String theatreId, LocalDate date) {
        return shows.values().stream()
                .filter(show -> show.getMovie().getMovieId().equals(movieId))
                .filter(show -> show.getShowDate().equals(date))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public List<Show> getShowsByMovie(String movieId) {
        return shows.values().stream()
                .filter(show -> show.getMovie().getMovieId().equals(movieId))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public Show getShowById(String showId) {
        return shows.get(showId);
    }
}

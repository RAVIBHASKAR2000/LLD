package models;

import java.time.LocalDate;

public class Movie {
    private String movieId;
    private String title;
    private Genre genre;
    private int duration;
    private String language;
    private LocalDate releaseDate;
    private double rating;

    public Movie(String movieId, String title, Genre genre, int duration, String language, LocalDate releaseDate) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.language = language;
        this.releaseDate = releaseDate;
        this.rating = 0.0;
    }

    // Getters
    public String getMovieId() { return movieId; }
    public String getTitle() { return title; }
    public Genre getGenre() { return genre; }
}

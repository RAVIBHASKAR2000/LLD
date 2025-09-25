package service;
import models.*;

import  java.util.*;

public class MovieService {
    private Map<String, Movie> movies;

    public MovieService() {
        this.movies = new HashMap<>();
    }

    public void addMovie(Movie movie) {
        movies.put(movie.getMovieId(), movie);
        System.out.println("Movie added: " + movie.getTitle());
    }

    public void removeMovie(String movieId) {
        Movie removed = movies.remove(movieId);
        if (removed != null) {
            System.out.println("Movie removed: " + removed.getTitle());
        }
    }

    public List<Movie> searchMovies(String query) {
        return movies.values().stream()
                .filter(movie -> movie.getTitle().toLowerCase().contains(query.toLowerCase()))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public List<Movie> getMoviesByGenre(Genre genre) {
        return movies.values().stream()
                .filter(movie -> movie.getGenre() == genre)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public Movie getMovieById(String movieId) {
        return movies.get(movieId);
    }
}

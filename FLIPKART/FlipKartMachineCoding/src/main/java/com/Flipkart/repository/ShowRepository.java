package main.java.com.Flipkart.repository;
import main.java.com.Flipkart.model.Genre;
import main.java.com.Flipkart.model.Show;

import java.util.*;

public class ShowRepository {
    private static ShowRepository instance = null;
    private Map<String, Show> showMap = new HashMap<>();

    private ShowRepository() {}

    public static ShowRepository getInstance() {
        if (instance == null) {
            instance = new ShowRepository();
        }
        return instance;
    }

    public void registerShow(Show show) {
        showMap.put(show.getName(), show);
    }

    public Show getShow(String name) {
        return showMap.get(name);
    }

    public List<Show> getShowsByGenre(Genre genre) {
        List<Show> result = new ArrayList<>();
        for (Show show : showMap.values()) {
            if (show.getGenre() == genre) {
                result.add(show);
            }
        }
        return result;
    }
}
package service;


import models.*;

import  java.util.*;
public class TheatreService {
    private Map<String, Theatre> theatres;

    public TheatreService() {
        this.theatres = new HashMap<>();
    }

    public void addTheatre(Theatre theatre) {
        theatres.put(theatre.getTheatreId(), theatre);
        System.out.println("Theatre added: " + theatre.getTheatreName());
    }

    public void removeTheatre(String theatreId) {
        Theatre removed = theatres.remove(theatreId);
        if (removed != null) {
            System.out.println("Theatre removed: " + removed.getTheatreName());
        }
    }

    public List<Theatre> searchTheatres(String query) {
        return theatres.values().stream()
                .filter(theatre -> theatre.getTheatreName().toLowerCase().contains(query.toLowerCase()))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public List<Theatre> getTheatresByCity(String cityId) {
        return theatres.values().stream()
                .filter(theatre -> theatre.getCity().getCityId().equals(cityId))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public Theatre getTheatreById(String theatreId) {
        return theatres.get(theatreId);
    }
}

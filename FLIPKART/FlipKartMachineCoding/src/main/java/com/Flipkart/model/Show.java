package main.java.com.Flipkart.model;

import java.util.*;

public class Show {
    private String name;
    private Genre genre;
    private Map<String, ShowSlot> slots;

    public Show(String name, Genre genre) {
        this.name = name;
        this.genre = genre;
        this.slots = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return genre;
    }

    public Map<String, ShowSlot> getSlots() {
        return slots;
    }

    public void addSlot(ShowSlot slot) {
        this.slots.put(slot.getSlotTime(), slot);
    }
}
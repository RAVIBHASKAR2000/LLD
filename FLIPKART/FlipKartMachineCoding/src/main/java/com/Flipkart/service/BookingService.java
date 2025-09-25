package main.java.com.Flipkart.service;
import main.java.com.Flipkart.model.*;
import main.java.com.Flipkart.repository.*;
import java.util.*;

public class BookingService {

    private  static BookingService service;
    private BookingService(){
    }
    public  static  BookingService getInstance(){
        if(service==null){
            service = new BookingService();
        }
        return service;
    }
    private ShowRepository showRepo = ShowRepository.getInstance();
    private BookingRepository bookingRepo = BookingRepository.getInstance();

    public void bookTicket(String username, String showName, String slotTime, int persons) {
        Show show = showRepo.getShow(showName);
        if (show == null){
            System.out.println("Invalid show ");
            return;
        }

        if (!show.getSlots().containsKey(slotTime)){
            System.out.println("Invalid Slot selected ");
            return;
        }

        // Check for overlapping bookings
        List<Booking> existing = bookingRepo.getUserBookings(username);

        for (Booking b : existing) {
            if (b.getSlotTime().equals(slotTime)) {
                System.out.println("User already has a booking in this slot");
                return;
            }
        }

        ShowSlot slot = show.getSlots().get(slotTime);
        Booking booking = new Booking(username, showName, slotTime, persons);

        if (slot.book(persons)) {
            bookingRepo.addBooking(booking);
            System.out.println("Booked. Booking id: " + booking.getBookingId());
        } else {
            slot.getWaitList().offer(booking);
            System.out.println("Booking Id : " + booking.getBookingId() + ", Wait listing");
        }
    }

    public void cancelBooking(String bookingId) {
        Booking b = bookingRepo.getBooking(bookingId);
        if (b == null) {
            System.out.println("Invalid booking");
            return;
        }

        Show show = showRepo.getShow(b.getShowName());
        ShowSlot slot = show.getSlots().get(b.getSlotTime());

        slot.cancel(b.getNumPersons());
        bookingRepo.cancelBooking(bookingId);

        // Reassign from waitlist
        while (!slot.getWaitList().isEmpty()) {
            Booking w = slot.getWaitList().peek();
            if (slot.getAvailable() >= w.getNumPersons()) {
                slot.book(w.getNumPersons());
                w.markFromWaitlist();
                bookingRepo.addBooking(w);
                slot.getWaitList().poll();
                System.out.println("Waitlisted booking promoted: " + w.getBookingId());
                break;
            } else {
                // need to implement will think of some way to skip first and go to next;
                break;
            }
        }

        System.out.println("Booking Canceled");
    }

    public void showAvailableByGenre(String genreStr) {
        Genre genre = Genre.valueOf(genreStr.toUpperCase());
        List<Show> shows = showRepo.getShowsByGenre(genre);

        for (Show s : shows) {
            for (ShowSlot slot : s.getSlots().values()) {
                if (slot.getAvailable() > 0) {
                    System.out.println(s.getName() + ": (" + slot.getSlotTime() + ") " + slot.getAvailable());
                }
            }
        }
    }

    public void showUserBookings(String username) {
        List<Booking> list = bookingRepo.getUserBookings(username);
        for (Booking b : list) {
            System.out.println("BookingId: " + b.getBookingId()
                    + ", Show: " + b.getShowName()
                    + ", Slot: " + b.getSlotTime()
                    + ", Persons: " + b.getNumPersons()
                    + (b.isFromWaitlist() ? " (From Waitlist)" : ""));
        }
    }

}
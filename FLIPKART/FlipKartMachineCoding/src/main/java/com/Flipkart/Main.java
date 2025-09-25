package main.java.com.Flipkart;
import main.java.com.Flipkart.service.*;
import main.java.com.Flipkart.model.SlotInput;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("-------------Welcome to India'sGOTLatent  Live Show------------");


        ShowService showService =  ShowService.getInstance();
        BookingService bookingService = BookingService.getInstance();

        showService.registerShow("TMKOC", "Comedy");

        List<SlotInput> TMKOCSlots = Arrays.asList(
                new SlotInput("09:00-10:00", 3),
                new SlotInput("12:00-13:00", 2),
                new SlotInput("15:00-16:00", 5)
        );

        showService.onboardShowSlots("TMKOC", TMKOCSlots);

        showService.registerShow("The Sonu Nigam Live Event", "Singing");
        List<SlotInput> SonuNigamSlot = Arrays.asList(
                new SlotInput("10:00-11:00", 3),
                new SlotInput("13:00-14:00", 2),
                new SlotInput("17:00-18:00", 1)
        );
        showService.onboardShowSlots("The Sonu Nigam Live Event", SonuNigamSlot);

        bookingService.showAvailableByGenre("Comedy");

        bookingService.bookTicket("UserA", "TMKOC", "12:00-13:00", 2);
        bookingService.bookTicket("UserB", "TMKOC", "12:00-13:00", 2); // waitlisted

        bookingService.cancelBooking("1000");
        bookingService.bookTicket("UserC", "TMKOC", "12:00-13:00", 1);
        bookingService.showAvailableByGenre("Comedy");


        bookingService.showUserBookings("UserA");
    }
}

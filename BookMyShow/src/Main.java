import models.*;
import  service.*;

import java.time.LocalDate;
import java.time.LocalTime;
import  java.util.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("=== BOOKMYSHOW SYSTEM DEMO ===\n");
        // Initialize services
        MovieService movieService = new MovieService();
        TheatreService theatreService = new TheatreService();
        ShowService showService = new ShowService();
        BookingService bookingService = new BookingService();
        PaymentService paymentService = new PaymentService();
        NotificationService notificationService = new NotificationService();

        // Create sample data
        setupSampleData(movieService, theatreService, showService);

        // Create customer
        Customer customer = new Customer("C001", "john_doe", "john@email.com", "9876543210", LocalDate.of(1990, 5, 15));
        System.out.println("Customer created: " + customer.getUsername());

        // Simulate booking flow
        try {
            System.out.println("\n=== BOOKING FLOW SIMULATION ===");

            // 1. Search movies
            System.out.println("\n1. Searching for movies...");
            List<Movie> movies = movieService.searchMovies("Avengers");
            if (!movies.isEmpty()) {
                Movie selectedMovie = movies.get(0);
                System.out.println("Selected movie: " + selectedMovie.getTitle());

                // 2. Get shows for the movie
                System.out.println("\n2. Finding shows...");
                List<Show> shows = showService.getShowsByMovie(selectedMovie.getMovieId());
                if (!shows.isEmpty()) {
                    Show selectedShow = shows.get(0);
                    System.out.println("Selected show: " + selectedShow.getShowDate() + " " + selectedShow.getShowTime());

                    // 3. Get available seats
                    System.out.println("\n3. Checking available seats...");
                    List<Seat> availableSeats = selectedShow.getScreen().getAvailableSeats(selectedShow.getShowId());

                    if (availableSeats.size() >= 2) {
                        // Select 2 seats
                        List<Seat> selectedSeats = Arrays.asList(availableSeats.get(0), availableSeats.get(1));
                        System.out.println("Selected seats: " + selectedSeats.get(0).getSeatNumber() + ", " + selectedSeats.get(1).getSeatNumber());

                        // 4. Block seats
                        System.out.println("\n4. Blocking seats...");
                        SeatHold seatHold = bookingService.blockSeats(customer.getUserId(), selectedShow, selectedSeats);

                        // 5. Process booking and payment
                        System.out.println("\n5. Processing booking and payment...");
                        Booking booking = bookingService.bookTickets(seatHold.getHoldId(), customer, paymentService, "Credit Card");

                        // 6. Send confirmation
                        System.out.println("\n6. Sending confirmation...");
                        notificationService.sendBookingConfirmation(booking);

                        // 7. Print tickets
                        System.out.println("7. Generating tickets...");
                        for (Ticket ticket : booking.getTickets()) {
                            System.out.println(ticket.generateTicket());
                            System.out.println("---");
                        }

                        // 8. Show booking history
                        System.out.println("\n8. Booking History:");
                        List<Booking> history = bookingService.getBookingHistory(customer.getUserId());
                        for (Booking b : history) {
                            System.out.println("Booking ID: " + b.getBookingId() +
                                    ", Movie: " + b.getShow().getMovie().getTitle() +
                                    ", Status: " + b.getStatus());
                        }

                        // 9. Demonstrate cancellation (optional)
                        System.out.println("\n9. Demonstrating cancellation...");
                        boolean cancelled = bookingService.cancelBooking(booking.getBookingId());
                        if (cancelled) {
                            notificationService.sendCancellationNotice(booking);
                        }

                    } else {
                        System.out.println("Not enough seats available");
                    }
                } else {
                    System.out.println("No shows available for this movie");
                }
            } else {
                System.out.println("No movies found");
            }

        } catch (Exception e) {
            System.out.println("Booking failed: " + e.getMessage());
        }

        System.out.println("\n=== DEMO COMPLETED ===");
    }


    private static void setupSampleData(MovieService movieService, TheatreService theatreService, ShowService showService) {
        System.out.println("Setting up sample data...");

        // Create cities
        City bangalore = new City("BLR", "Bangalore", "Karnataka", "560001");
        City mumbai = new City("MUM", "Mumbai", "Maharashtra", "400001");

        // Create addresses
        Address address1 = new Address("ADDR1", "123 MG Road", "Indiranagar", "Near Metro Station", "560038");
        Address address2 = new Address("ADDR2", "456 Brigade Road", "Commercial Street", "Near Church Street", "560025");

        // Create theatres
        Theatre pvr = new Theatre("T001", "PVR Cinemas", bangalore, address1, "080-12345678");
        Theatre inox = new Theatre("T002", "INOX Theatre", bangalore, address2, "080-87654321");

        theatreService.addTheatre(pvr);
        theatreService.addTheatre(inox);

        // Create screens
        Screen screen1 = new Screen("S001", "Screen 1", "IMAX", 200);
        Screen screen2 = new Screen("S002", "Screen 2", "Regular", 150);
        Screen screen3 = new Screen("S003", "Screen 1", "4DX", 100);

        pvr.addScreen(screen1);
        pvr.addScreen(screen2);
        inox.addScreen(screen3);

        // Create seats for screens
        createSeatsForScreen(screen1, 200);
        createSeatsForScreen(screen2, 150);
        createSeatsForScreen(screen3, 100);

        // Create movies
        Movie avengers = new Movie("M001", "Avengers: Endgame", Genre.ACTION, 180, "English", LocalDate.of(2024, 4, 26));
        Movie joker = new Movie("M002", "Joker", Genre.DRAMA, 122, "English", LocalDate.of(2024, 10, 4));
        Movie inception = new Movie("M003", "Inception", Genre.SCI_FI, 148, "English", LocalDate.of(2024, 7, 16));

        movieService.addMovie(avengers);
        movieService.addMovie(joker);
        movieService.addMovie(inception);

        // Create shows
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);

        Show show1 = new Show("SH001", avengers, screen1, today, LocalTime.of(18, 0), 250.0);
        Show show2 = new Show("SH002", avengers, screen1, today, LocalTime.of(21, 30), 250.0);
        Show show3 = new Show("SH003", joker, screen2, tomorrow, LocalTime.of(15, 0), 200.0);
        Show show4 = new Show("SH004", inception, screen3, tomorrow, LocalTime.of(19, 0), 300.0);

        showService.addShow(show1);
        showService.addShow(show2);
        showService.addShow(show3);
        showService.addShow(show4);

        System.out.println("Sample data setup completed!\n");
    }

    private static void createSeatsForScreen(Screen screen, int totalSeats) {
        List<Seat> seats = screen.getSeats();
        int seatsPerRow = 10;
        int rows = (totalSeats + seatsPerRow - 1) / seatsPerRow;

        for (int row = 0; row < rows; row++) {
            char rowChar = (char) ('A' + row);
            for (int seatNum = 1; seatNum <= seatsPerRow && (row * seatsPerRow + seatNum - 1) < totalSeats; seatNum++) {
                String seatId = "SEAT_" + screen.getScreenId() + "_" + rowChar + seatNum;
                String seatNumber = rowChar + String.valueOf(seatNum);

                Seat seat;
                // Make every 5th seat a recliner for demo
                if (seatNum % 5 == 0) {
                    seat = new ReclinerSeat(seatId, seatNumber, String.valueOf(rowChar));
                } else {
                    seat = new RegularSeat(seatId, seatNumber, String.valueOf(rowChar));
                }

                seats.add(seat);
            }
        }
    }
}
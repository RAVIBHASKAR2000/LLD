package main.java.org.lldProblemStatements.TicketBookingPlatform;

public class BookingService {
    public Ticket createBooking(Theater theater, String time, String movieName,String SeatType, User user){
        // find the movie Auditorium
        Auditorium audi =  theater.findAudiForMovieName(movieName);

        Seats seat = audi.bookNormalSeat(2);
        seat.bookSeat(user);
        Event movie = audi.getEventAt(time);
        Ticket ticket  =  new MovieTicket(movie,user,seat,audi);
        return ticket;
    }
}

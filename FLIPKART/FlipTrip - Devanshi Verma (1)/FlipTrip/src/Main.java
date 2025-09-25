import java.lang.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Adding flight schedules");

        FlightBookingSystem flightBookingSystem = new FlightBookingSystem();

        flightBookingSystem.declareFlight("JetAir", "DEL", "BLR", 500, false);
        flightBookingSystem.declareFlight("JetAir", "BLR", "LON", 1000, false);
        flightBookingSystem.declareFlight("Delta", "DEL", "LON", 2000, false);
        flightBookingSystem.declareFlight("Delta", "LON", "NYC", 2000, false);
        flightBookingSystem.declareFlight("Indigo", "LON", "NYC", 2500, false);
        flightBookingSystem.declareFlight("Indigo", "DEL", "BLR", 600, false);
        flightBookingSystem.declareFlight("Indigo", "BLR", "PAR", 800, false);
        flightBookingSystem.declareFlight("Indigo", "PAR", "LON", 300, false);

        flightBookingSystem.findFlightWithMinHops("DEL", "NYC", false);
        flightBookingSystem.findCheapestFlight("DEL", "NYC", false);
        
        FlightBookingSystem flightBookingSystem2 = new FlightBookingSystem();

        System.out.println("Adding flight schedules for meals");
        flightBookingSystem2.declareFlight("JetAir", "DEL", "BLR", 500, true);
        flightBookingSystem2.declareFlight("JetAir", "BLR", "LON", 1000, true);
        flightBookingSystem2.declareFlight("Delta", "DEL", "LON", 2000, true);
        flightBookingSystem2.declareFlight("Delta", "LON", "NYC", 2000, true);
        flightBookingSystem2.declareFlight("Indigo", "LON", "NYC", 2500, true);
        flightBookingSystem2.declareFlight("Indigo", "DEL", "BLR", 600, true);
        flightBookingSystem2.declareFlight("Indigo", "BLR", "PAR", 800, true);
        flightBookingSystem2.declareFlight("Indigo", "PAR", "LON", 300, true);

        flightBookingSystem2.findFlightWithMinHops("DEL", "NYC", true);
        flightBookingSystem2.findCheapestFlight("DEL", "NYC", true);
    }
}
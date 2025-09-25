package org.example;

public class Main {
    public static void main(String[] args) {
        Flights flights = new Flights();
        flights.registerFlights(new Flight("JetAir",City.DEL,City.BLR,500));
        flights.registerFlights(new Flight("JetAir",City.BLR,City.LON,1000));
        flights.registerFlights(new Flight("Delta",City.DEL,City.LON,2000));
        flights.registerFlights(new Flight("Delta",City.LON,City.NYC,2000));
        flights.registerFlights(new Flight("IndiGo",City.LON,City.NYC,2500));
        flights.registerFlights(new Flight("IndiGo",City.DEL,City.BLR,600));
        flights.registerFlights(new Flight("IndiGo",City.BLR,City.PAR,800));
        flights.registerFlights(new Flight("IndiGo",City.PAR,City.LON,300));


        flights.search(City.DEL,City.NYC,true);

    }
}

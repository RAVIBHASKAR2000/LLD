package org.example.airlinesystem;

import org.example.airlinesystem.extraservice.DrinkService;
import org.example.airlinesystem.extraservice.ExtraBaggageService;
import org.example.airlinesystem.extraservice.MealService;
import org.example.airlinesystem.extraservice.Service;
import org.example.airlinesystem.model.Airline;
import org.example.airlinesystem.model.City;
import org.example.airlinesystem.model.FlightDetails;
import org.example.airlinesystem.search.FlightDetailsGraph;

import java.util.*;

public class Main {
    public static void main(String[] args){
        FlightDetailsGraph graph = new FlightDetailsGraph();

        City cityA = new City("BLR");
        City cityB = new City("AMD");
        City cityC = new City("DEL");
        City cityD = new City("HYD");

        graph.addCity(cityA);
        graph.addCity(cityB);
        graph.addCity(cityC);
        graph.addCity(cityD);

        Airline airline1 = new Airline("JetAir");
        Airline airline2 = new Airline("Indigo");
        Airline airline3 = new Airline("Vistara");

        Set<Service> services1 = new HashSet<>(Arrays.asList(new MealService(), new DrinkService()));
        Set<Service> services2 = new HashSet<>(Collections.singletonList(new ExtraBaggageService()));
        Set<Service> services3 = new HashSet<>(Collections.singletonList(new MealService()));

        graph.addFlight("BLR", "AMD", 100, airline1, services1);
        graph.addFlight("BLR", "AMD", 600, airline2, services2);
        graph.addFlight("BLR", "AMD", 700, airline3, services3);
        graph.addFlight("BLR", "HYD", 700, airline1, services1);
        graph.addFlight("BLR", "HYD", 700, airline2, services2);
        graph.addFlight("BLR", "HYD", 700, airline3, services1);
        graph.addFlight("AMD", "DEL", 1000, airline1, services1);
        graph.addFlight("AMD", "DEL", 100, airline2, services1);
        graph.addFlight("DEL", "HYD", 200, airline2, services1);

        List<FlightDetails> optimalPath = graph.findOptimalPath("BLR", "DEL");
        int totalCost = 0;
        for (FlightDetails flightDetails : optimalPath){
            System.out.println("Airline = " + flightDetails.getAirline().getName() +
                    flightDetails.getSource().getName() +" -> "
                                + flightDetails.getDestination().getName()
                                + " : price = " + flightDetails.getCost());
            totalCost += flightDetails.getCost();
        }
        System.out.println("Total cost = "+totalCost);


        List<FlightDetails> optimalPath2 = graph.findOptimalPath("BLR", "AMD");
        totalCost = 0;
        for (FlightDetails flightDetails : optimalPath2){
            System.out.println("Airline = " + flightDetails.getAirline().getName() +
                    flightDetails.getSource().getName() +" -> "
                    + flightDetails.getDestination().getName()
                    + " : price = " + flightDetails.getCost());
            totalCost += flightDetails.getCost();
        }
        System.out.println("Total cost = "+totalCost);

        Set<Class<? extends Service>> requiredServices = new HashSet<>(Arrays.asList(MealService.class, DrinkService.class));

        List<FlightDetails> optimalPath3 = graph.findOptimalPathWithExtraServices("BLR", "HYD", requiredServices);
        totalCost = 0;
        for (FlightDetails flightDetails : optimalPath3){
            System.out.println("Airline = " + flightDetails.getAirline().getName() +
                    flightDetails.getSource().getName() +" -> "
                    + flightDetails.getDestination().getName()
                    + " : price = " + flightDetails.getCost());
            totalCost += flightDetails.getCost();
        }
        System.out.println("Total cost = "+totalCost);
    }
}

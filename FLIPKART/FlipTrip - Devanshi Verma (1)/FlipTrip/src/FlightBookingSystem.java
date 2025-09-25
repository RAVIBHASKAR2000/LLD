import java.util.*;

public class FlightBookingSystem {

    HashMap<String, List<Flight>> flightMap;

    public FlightBookingSystem() {
        flightMap = new HashMap<>();
    }

    public void declareFlight(String airlineName, String sourceCity, String destinationCity, int cost, boolean isMeal) {
        Flight flight = new Flight(airlineName, sourceCity, destinationCity, cost, isMeal);
        flightMap.computeIfAbsent(sourceCity, k -> new ArrayList<>()).add(flight);
    }

    public void findCheapestFlight(String source, String destination, boolean isMeal) {
        PriorityQueue<Path> pq = new PriorityQueue<>(Comparator.comparingInt(Path :: getTotalCost));
        pq.add(new Path(source, 0 , new ArrayList<>()));

        while (!pq.isEmpty()) {
            Path path = pq.poll();

            if(path.currCity.equals(destination)) {
                System.out.println("Cheapest route:");
                printPath(path.flights, path.totalCost);
                break;
            }
            if(!flightMap.containsKey(path.currCity)) {
                continue;
            }

            for(Flight flight : flightMap.get(path.currCity)) {
                List<Flight> flightList = new ArrayList<>(path.flights);
                flightList.add(flight);
                if(isMeal && !flight.isMeal()) {
                    continue;
                }
                pq.add(new Path(flight.getDestinationCity(), flight.getCost() + path.getTotalCost(), flightList));
            }
        }
    }

    public void findFlightWithMinHops(String source, String destination, boolean isMeal) {
        Queue<Path> queue = new LinkedList<>();
        queue.add(new Path(source, 0 , new ArrayList<>()));

        Map<String, Integer> vis = new HashMap<>();

        while (!queue.isEmpty()) {
            Path path = queue.poll();
            int currHops = path.flights.size();

            if(path.currCity.equals(destination)) {
                System.out.println("Min hops:");
                printPath(path.flights, path.totalCost);
                break;
            }

            if(vis.containsKey(path.currCity) && vis.get(path.currCity) <= path.totalCost) {
                continue;
            }

            vis.put(path.currCity, path.totalCost);

            if(!flightMap.containsKey(path.currCity)) {
                continue;
            }

            for(Flight flight : flightMap.get(path.currCity)) {
                List<Flight> flightList = new ArrayList<>(path.flights);
                flightList.add(flight);
                if(isMeal && !flight.isMeal()) {
                    continue;
                }
                queue.add(new Path(flight.getDestinationCity(), flight.getCost() + path.getTotalCost(), flightList));
            }
        }
    }

    private void printPath(List<Flight> flights, int totalCost) {
        for (Flight flight : flights) {
            System.out.println(flight.getSourceCity() + " " + flight.getDestinationCity() + " " + flight.getCost());
        }
        System.out.println(flights.size() + " flights");
        System.out.println(totalCost);
    }
}

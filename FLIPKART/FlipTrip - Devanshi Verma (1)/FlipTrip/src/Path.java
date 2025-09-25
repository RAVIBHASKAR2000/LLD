import java.util.List;

public class Path {
    public String currCity;
    public int totalCost;
    List<Flight> flights;

    public Path(String currCity, int totalCost, List<Flight> flights) {
        this.currCity = currCity;
        this.totalCost = totalCost;
        this.flights = flights;
    }

    public int getTotalCost() {
        return totalCost;
    }
}

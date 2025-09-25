public class Flight {
    private String airlineName;
    private String sourceCity;
    private String destinationCity;
    private int cost;
    private boolean isMeal;

    public Flight(String airlineName, String sourceCity, String destinationCity, int cost, boolean isMeal) {
        this.airlineName = airlineName;
        this.sourceCity = sourceCity;
        this.destinationCity = destinationCity;
        this.cost = cost;
        this.isMeal = isMeal;
    }

    public String getSourceCity() {
        return sourceCity;
    }

    public void setSourceCity(String sourceCity) {
        this.sourceCity = sourceCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public boolean isMeal() {
        return isMeal;
    }

    public void setMeal(boolean meal) {
        this.isMeal = meal;
    }
}

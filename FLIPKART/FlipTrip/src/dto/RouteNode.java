package dto;

import java.util.List;

public  class RouteNode {
    int totalCost;
    List<Flight> route;

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public List<Flight> getRoute() {
        return route;
    }

    public void setRoute(List<Flight> route) {
        this.route = route;
    }

    public RouteNode(int totalCost, List<Flight> route) {
        this.totalCost = totalCost;
        this.route = route;
    }
}
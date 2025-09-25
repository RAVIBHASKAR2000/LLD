package dto;

import enums.ProBo;
import util.FlightUtil;

import java.util.List;

public class Flight {
int id;
String airline;
String source;
String destination;
int cost;
List<ProBo> proBos;

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", airline='" + airline + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", cost=" + cost +
                ", proBos=" + proBos +
                '}';
    }

    public Flight(String airline, String source, String destination, int cost, List<ProBo> proBos) {
        this.id= FlightUtil.getFlightId();
        this.airline=airline;
        this.source = source;
        this.destination = destination;
        this.cost = cost;
        this.proBos = proBos;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<ProBo> getProBos() {
        return proBos;
    }

    public void setProBos(List<ProBo> proBos) {
        this.proBos = proBos;
    }

}

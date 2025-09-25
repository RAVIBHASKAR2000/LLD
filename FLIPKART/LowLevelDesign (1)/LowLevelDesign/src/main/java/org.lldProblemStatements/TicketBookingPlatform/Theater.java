package main.java.org.lldProblemStatements.TicketBookingPlatform;

import java.util.List;

public class Theater {
    private String name;
    List<Auditorium> auditoriums;

    public Theater(int numberOfAuditoriums, String name){
        for(int i=0;i<numberOfAuditoriums;i++){
            auditoriums.add(new MovieAuditorium(10,10));
        }
        this.name = name;
    }

    public Auditorium getAuditorium(int auditoriumNumber){
        return auditoriums.get(auditoriumNumber);
    }

    public Auditorium findAudiForMovieName(String movieName){
        return auditoriums.get(2);
    }


}

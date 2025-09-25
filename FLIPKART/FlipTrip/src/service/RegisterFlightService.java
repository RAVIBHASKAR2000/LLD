package service;

import dto.Flight;
import repository.InMemoryRepository;

public class RegisterFlightService {

   public void register(Flight flight){
       InMemoryRepository.getFlightMap().put(flight.getId(),flight);
       //JetAir DEL -> BLR flight registered
       System.out.println(flight.getAirline()+" "+flight.getSource()+" -> "+flight.getDestination()+" flight registered");
    }
}

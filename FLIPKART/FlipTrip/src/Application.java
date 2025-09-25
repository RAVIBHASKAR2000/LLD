import dto.Flight;
import enums.ProBo;
import repository.InMemoryRepository;
import service.RegisterFlightService;
import service.SearchFlightsService;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        InMemoryRepository inMemoryRepository=new InMemoryRepository();

        RegisterFlightService registerFlightService=new RegisterFlightService();

       // Flight flight=new Flight("JetAir","DEL","BLR",500,new ArrayList<>());

        registerFlightService.register(new Flight("JetAir","DEL","BLR",500,new ArrayList<>()));
        registerFlightService.register(new Flight("JetAir","BLR","LON",1000,new ArrayList<>()));
        registerFlightService.register(new Flight("Delta","DEL","LON",2000,new ArrayList<>()));
        registerFlightService.register(new Flight("Delta","LON","NYC",2000,new ArrayList<>()));
        registerFlightService.register(new Flight("IndiGo","LON","NYC",2500,new ArrayList<>(Arrays.asList(ProBo.serves_meals))));
        registerFlightService.register(new Flight("IndiGo","DEL","BLR",600,new ArrayList<>(Arrays.asList(ProBo.serves_meals))));
        registerFlightService.register(new Flight("IndiGo","BLR","PAR",800,new ArrayList<>(Arrays.asList(ProBo.serves_meals))));
        registerFlightService.register(new Flight("IndiGo","PAR","LON",300,new ArrayList<>(Arrays.asList(ProBo.serves_meals))));


        SearchFlightsService searchFlightsService=new SearchFlightsService();


        searchFlightsService.search("DEL","NYC");

        searchFlightsService.filterSearch("DEL","NYC",ProBo.serves_meals);

    }
}

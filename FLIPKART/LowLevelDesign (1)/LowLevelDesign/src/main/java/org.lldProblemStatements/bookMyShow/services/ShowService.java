package main.java.org.lldProblemStatements.bookMyShow.services;

import com.sun.source.tree.InstanceOfTree;
import main.java.org.lldProblemStatements.bookMyShow.models.AdminUser;
import main.java.org.lldProblemStatements.bookMyShow.models.Movie;
import main.java.org.lldProblemStatements.bookMyShow.models.Theater;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ShowService {
    private HashMap<Theater, List<Movie>> movieSchedule;
    private static ShowService instance;

    private ShowService(){
        this.movieSchedule = new HashMap<>();
    }

    public static ShowService getInstance(){
        if(instance==null){
            instance = new ShowService();
        }
        return instance;
    }

    public void addMovies(AdminUser user, Movie movie, Theater theater, int startingTime){
        // validate the adminUser
        int endingTime = startingTime + ((2*movie.getDuration())-1);
        if(!movieSchedule.containsKey(theater)){
            movieSchedule.put(theater, new ArrayList<>(Collections.nCopies(24,null)));
        }

        for(int i=startingTime;i<=endingTime;i++){
            if(movieSchedule.get(theater).get(i)==null){
                movieSchedule.get(theater).set(i,movie);
            }
            else{
                System.out.println("This time slot is already booked by another movie!");
                return;
            }
        }
    }


}

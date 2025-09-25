package main.java.com.Flipkart.service;
import main.java.com.Flipkart.model.*;
import main.java.com.Flipkart.repository.ShowRepository;
import java.util.*;

public class ShowService {
    //SINGLETON CLASS
    private  static ShowService service;

    private ShowService(){

    }

    public  static  ShowService getInstance(){
        if(service==null){
            service = new ShowService();
        }
        return service;
    }

    private ShowRepository repo = ShowRepository.getInstance();

    public void registerShow(String name, String genreStr) {
        Genre genre = Genre.valueOf(genreStr.toUpperCase());
        Show show = new Show(name, genre);
        repo.registerShow(show);
        System.out.println(name + " show is registered !!");
    }

    public void onboardShowSlots(String name, List<SlotInput> slotDetails) {
        Show show = repo.getShow(name);
        if (show == null) {
            System.out.println("Show not found.");
            return;
        }

        for (SlotInput input : slotDetails) {
            String slotTime = input.getTimeRange();
            int cap = input.getCapacity();

            if (!isValidSlot(slotTime)) {
                System.out.println("Sorry, show timings are of 1 hour only");
                return;
            }
            if (show.getSlots().containsKey(slotTime)) {
                System.out.println("Slot already exists");
                continue;
            }
            show.addSlot(new ShowSlot(slotTime, cap));
        }
        System.out.println("Done!");
    }

    private boolean isValidSlot(String slotTime) {
        String[] times = slotTime.split("-");
        if (times.length != 2) return false;

        int startHour = Integer.parseInt(times[0].split(":")[0]);
        int endHour = Integer.parseInt(times[1].split(":")[0]);

        if (startHour < 9 || startHour > 20) return false;

        // Duration must be exactly 1 hour
        return (endHour - startHour) == 1;

    }
}
package main.java.org.lldProblemStatements.RideSharingApp;

public class RideSharingAppClient {
    public static void main(String[] args){

        RideMatchingSystem appContext = RideMatchingSystem.getInstance();

        // Onboard API
        Driver driver1 = new Driver("Rohan", "rohan@gmail.com","89-123123123",new Location(11.129387,23.09123), new Car());
        RideMatchingSystem.registerDriver(driver1);
        Driver driver2 = new Driver("Krishna", "krishna@gmail.com","89-123123123",new Location(17.129387,21.09123), new Bike());
        RideMatchingSystem.registerDriver(driver2);
        Driver driver3 = new Driver("Balram", "krishna@gmail.com","89-123123123",new Location(145.129387,12.09123), new Car());
        RideMatchingSystem.registerDriver(driver3);


        // Onboard API
        Passenger p1 = new Passenger("Akshay", "akshay@gmail.com","1273818293", new Location(123.123123,123.3124));

        // search-ride
        Trip myTrip = RideMatchingSystem.findRide(p1,new Location(523.123213,435.3422),"Car");

        System.out.println("Your driver name is : "+ myTrip.getDriver().getName());
        System.out.println("Your total distance travelled will be :"+myTrip.getDistance());
        System.out.println("Your final fare will be :"+myTrip.getFare());


    }
}


/*
    POST OnboardUser
    Endpoint: POST /ride-sharing-app/v1alpha1/onboardUser
    Req Body: {
            "username": String,
            "phoneNumber": String,
            "userType": enum (DRIVER, PASSENGER),
            }
      Response Body: {
            "message": String -> Successfully onboarded user,
      }

      POST searchRide
 *
 */
package main.java.org.lld.FacadePattern;

public class Client {
    public static void main(String[] args){
        APIGateway gateway = new APIGateway();
        gateway.getFullUserInformation("akshaykumar.942k@gmail.com","123123-123-12-312-31-23-123-1-23");
    }
}

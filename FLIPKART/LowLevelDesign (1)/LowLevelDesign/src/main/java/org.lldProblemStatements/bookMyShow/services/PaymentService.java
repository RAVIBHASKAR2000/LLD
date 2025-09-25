package main.java.org.lldProblemStatements.bookMyShow.services;

import main.java.org.lldProblemStatements.bookMyShow.models.Payment;
import main.java.org.lldProblemStatements.bookMyShow.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PaymentService {
    private HashMap<User, List<Payment>> userPaymentMethods;
    private static PaymentService instance;

    private PaymentService(){
        this.userPaymentMethods = new HashMap<>();
    }

    public static PaymentService getInstance(){
        if(instance==null){
            instance = new PaymentService();
        }
        return instance;
    }

    public void addPaymentMethod(User user, Payment paymentMethod){
        if(!userPaymentMethods.containsKey(user)){
            userPaymentMethods.put(user, new ArrayList<>());
        }

        userPaymentMethods.get(user).add(paymentMethod);
    }

    public void removePaymentMethod(User user, Payment paymentMethod){
        // validate if user is valid
        // validate if the paymentMethod exists
        userPaymentMethods.get(user).remove(paymentMethod);
    }

    public boolean pay(User user, Payment paymentMethod,double amount){
        return paymentMethod.pay(amount,user);
    }
}

package main.java.org.lldProblemStatements.Splitwise;

import java.util.*;


public interface SplitStrategy {
    HashMap<User,Double> calculateSplit(double amount, List<User> splitAmong);
}

class EqualSplitStrategy implements SplitStrategy{
    @Override
    public HashMap<User, Double> calculateSplit(double amount, List<User> splitAmong) {
        HashMap<User,Double> res = new HashMap<>();
        double n = splitAmong.size();
        for(User user:splitAmong){
            res.put(user,(amount/n));
        }
//        System.out.println("I'm here");
        return res;
    }
}

class PercentageSplitStrategy implements SplitStrategy{
    private HashMap<User,Double> percent;

    public PercentageSplitStrategy(HashMap<User,Double> percent){
        this.percent = percent;
    }

    @Override
    public HashMap<User, Double> calculateSplit(double amount, List<User> splitAmong) {
        HashMap<User,Double> res = new HashMap<>();
        for(User user:splitAmong){
            double amountOwed = amount*(percent.get(user)/100);
            res.put(user,amountOwed);
        }

        return res;
    }
}
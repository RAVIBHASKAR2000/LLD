package main.java.com.Flipkart.strategy;
import  main.java.com.Flipkart.model.Show;
import java.util.List;

public interface ShowRankingStrategy {
    List<Show> rank(List<Show> shows);
}
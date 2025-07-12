package DecoratorPattern;
import  java.util.*;
public class Main {
    public  static  void main(String[] args) {
        BasePizza pizza1 = new ExtraCheese(new Margherita());

        System.out.println(pizza1.cost());


        BasePizza pizza2 = new ExtraCheese(new Mushrooms(new VegDelight()));

        System.out.println(pizza2.cost());
    }

}

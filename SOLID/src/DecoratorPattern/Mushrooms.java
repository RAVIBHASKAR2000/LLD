package DecoratorPattern;

public class Mushrooms implements ExtraToppingsDecorator{
    BasePizza basePizza ;

    public Mushrooms(BasePizza pizza){
        this.basePizza = pizza;
    }
    @Override
    public int cost() {
        return this.basePizza.cost() + 10;
    }
}

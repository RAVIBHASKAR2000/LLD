package DecoratorPattern;

public class ExtraCheese implements ExtraToppingsDecorator{

    BasePizza basePizza ;

    public ExtraCheese(BasePizza pizza){
        this.basePizza = pizza;
    }
    @Override
    public int cost() {
        return this.basePizza.cost() + 20;
    }
}

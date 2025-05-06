package StructuralDesignPattern.BuilderPattern;



public class Main {
    public static void main(String[] args) {
        Coffee coffee1 = new SimpleCoffee();
        System.out.println(coffee1.getDescription() + " : $" + coffee1.getCost());

        Coffee coffee2 = new MilkDecorator(coffee1);
        Coffee coffee3 = new SugarDecorator(coffee2);

        System.out.println(coffee3.getDescription() + " : $" + coffee3.getCost());
        System.out.println(coffee2.getDescription() + " : $" + coffee2.getCost());
    }
}

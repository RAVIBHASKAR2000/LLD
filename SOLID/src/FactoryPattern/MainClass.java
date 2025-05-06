package FactoryPattern;

public class MainClass {
    public static void main(String[] args) {


        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shapeobj = shapeFactory.getShape("CIRCLE");

        shapeobj.draw();

        Shape shapeobj2 = shapeFactory.getShape("SQAURE");

        shapeobj2.draw();
    }
}

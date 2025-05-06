package FactoryPattern;

public class ShapeFactory {
    public  Shape shape;


    Shape getShape(String input){

        switch (input){
            case  "CIRCLE": return  new Circle();
            case  "SQAURE": return  new Sqaure();
            default: return null;
        }
    }

}

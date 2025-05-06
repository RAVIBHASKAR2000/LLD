package PrototypePattern;

public class Shape implements Prototype  {

    private String type;
    private int x;
    private int y;

    public Shape(String type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }


    @Override
    public Prototype Clone1() {
        return new Shape(type, x , y);
    }

    public void show() {
        System.out.println("Shape: " + type + " at (" + x + ", " + y + ")");
    }
}

package PrototypePattern;

public class Main {
    public static void main(String[] args) {
        Shape original = new Shape("Circle", 10, 20);
        original.show();

        Shape clone = (Shape) original.Clone1();  // cloning!
        clone.show();
    }
}

package AbstractFactoryPattern;

public class main {

    public static void main(String[] args){

        GUIFactory factory;
        String osName = "windows";

        if (osName.contains("mac")) {
            factory = new MacFactory();
        } else {
            factory = new WindowFactory();
        }

        Application app = new Application(factory);
        app.run();

    }
}

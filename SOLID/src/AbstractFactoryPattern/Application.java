package AbstractFactoryPattern;

public class Application {
    private Button button;
    private ScrollBar scrollBar;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        scrollBar = factory.createScrollBar();
    }

    public void run() {
        button.click();
        scrollBar.scroll();
    }
}

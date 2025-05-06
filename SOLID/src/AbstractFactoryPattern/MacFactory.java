package AbstractFactoryPattern;

public class MacFactory implements  GUIFactory{
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new MacScroll();
    }
}

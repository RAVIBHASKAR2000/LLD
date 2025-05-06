package AbstractFactoryPattern;

public class WindowFactory implements GUIFactory{

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public ScrollBar createScrollBar() {
        return  new WindowsScroll();
    }
}

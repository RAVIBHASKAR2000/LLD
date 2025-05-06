package AbstractFactoryPattern;

public class WindowsScroll implements ScrollBar{
    @Override
    public void scroll() {
        System.out.println("scroll Windows");
    }
}

package src.coffeehouse;

public class Tea extends Beverage{

    public Tea(boolean extras) {
        super(extras);
    }

    @Override
    protected void brew() {
        System.out.println("Putting tea bag into cup");
    }

    @Override
    protected void addExtras() {
        System.out.println("Adding lemon");
    }
    
}

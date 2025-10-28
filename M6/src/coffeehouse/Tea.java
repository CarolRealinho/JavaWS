package coffeehouse;

public class Tea extends Beverage{
    public Tea(boolean extras){
        super(extras);
    }

    public void brew(){
        System.out.println("Putting tea bag into cup");
    }
    public void addExtras(){
        System.out.println("Adding lemon");
    }
}

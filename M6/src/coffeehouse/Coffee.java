package coffeehouse;

public class Coffee extends Beverage {
    public Coffee(boolean extras){
        super(extras);
    }

    public void brew(){
        System.out.println("Putting coffee powder into cup");
    }
    public void addExtras(){
        System.out.println("Adding milk and sugar");
    }
}

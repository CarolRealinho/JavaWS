package coffeehouse;

abstract public class Beverage {
    private boolean extras;

    protected Beverage(boolean extras){
        this.extras = extras;
    }

    abstract protected void brew();
    abstract protected void addExtras();

    protected void boilWater(){
        System.out.println("Boiling water");
    }

    protected void pourInCup(){
        System.out.println("Pouring into cup");
    }

    final public void prepareRecipe() {
        System.out.println("Preparing new beverage");
        boilWater();
        brew();
        pourInCup();
        if(this.extras)
            addExtras();
        System.out.println();
    }
}
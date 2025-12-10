package steps;

abstract public class AbstractStep {
    protected String description;

    protected AbstractStep(String description){
        this.description = description;
    }

    abstract public int getDuration();
    abstract public void display();
}

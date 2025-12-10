package steps;

public class BasicStep extends AbstractStep {
    private int duration;

    public BasicStep(String description, int duration){
        super(description);
        this.duration = duration;
    }

    @Override
    public int getDuration() {
        return this.duration;
    }

    @Override
    public void display() {
        String text = this.description + " " + this.duration + " minutes";
        System.out.println(text);
    }
}

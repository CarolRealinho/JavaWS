package steps;

import java.util.ArrayList;

public class Repeat extends AbstractStep{
    private int count;
    private ArrayList<AbstractStep> steps;

    public Repeat(String description, int count){
        super(description);
        this.count = count;
        this.steps = new ArrayList<>();
    }

    public void addStep(AbstractStep step){
        this.steps.add(step);
    }

    @Override
    public int getDuration() {
        int sum =0;
        for(int i=0;i<this.steps.size();i++){
            sum+=this.steps.get(i).getDuration();
        }
        return sum*count;
    }

    @Override
    public void display() {
        String text = this.description + " " + this.getDuration() + " minutes\nRépéter " + this.count + " fois";
        System.out.println(text);
        for(AbstractStep step: steps){
            step.display();
        }
        String text2 = this.description + " " + this.getDuration() + " minutes : fin";
        System.out.println(text2);
    }
}

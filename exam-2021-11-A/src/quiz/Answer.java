package quiz;

public class Answer {
    private String text;
    private boolean right;

    public Answer(String text, boolean right) {
        this.text = text;
        this.right = right;
    }

    public boolean isRight() {
        return this.right;
    }
    
    public String getText() {
        return this.text;
    }

}

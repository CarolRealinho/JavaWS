package quiz;

public class Answer {
    private String text;
    private boolean right;

    public Answer(String text, boolean right) {
        if(text == null){
            String anomaly = "The answer cannot be null!";
            throw new IllegalArgumentException(anomaly);
        }
        if(text.isEmpty()){
            String anomaly = "The answer cannot be empty!";
            throw new IllegalArgumentException(anomaly);
        }
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

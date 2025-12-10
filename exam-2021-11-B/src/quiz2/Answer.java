package quiz2;

public class Answer {
    private String text;
    private double percent;

    public Answer(String text, double percent) {
        if(percent<0.0 || percent>100.0){
            String anomaly = "Answer percentage should be in the interval [0,100] and not "+percent;
            throw new IllegalArgumentException(anomaly);
        }
        if(text ==null || text.isBlank()){
            String anomaly = "Answer should contain some text (it is null or empty)";
            throw new IllegalArgumentException(anomaly);
        }
        this.text = text;
        this.percent = percent;
    }

    public String getText() {
        return this.text;
    }

    public double getPercent() {
        return this.percent;
    }

}

package quiz;

public class ExceptionsMain {
    public static void main(String[] args) {
        // TODO: Test each possible anomaly by uncommenting one of the above lines
        Answer ans = new Answer("", true);
        SingleChoiceQuestion question = new SingleChoiceQuestion("bla");
        question.addAnswer(ans);
        //new MultipleChoiceQuestion("");
    }
}

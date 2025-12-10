package quiz2;

public class SingleChoiceQuestion extends MultipleChoiceQuestion {

    public SingleChoiceQuestion(String questionText) {
        super(questionText);
    }

    public boolean isValid() {
        return super.answersPercentsSum() == 100.0;
    }
}

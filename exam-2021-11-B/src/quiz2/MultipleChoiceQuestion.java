package quiz2;

import java.util.ArrayList;

public class MultipleChoiceQuestion extends AbstractQuestion{
    protected ArrayList<Answer> answers;
    private String questionText;

    public MultipleChoiceQuestion(String questionText) {
        
        this.questionText = questionText;
        this.answers = new ArrayList<Answer>();
    }

    public void addAnswer(Answer a) {
        this.answers.add(a);
    }

    public double answersPercentsSum() {
        double percentTotal = 0;
        for (Answer a: answers){
            percentTotal += a.getPercent();
        }
        return percentTotal;
    }

    public boolean isValid() {
        return this.answersPercentsSum() == 100.0;
    }

    public void showToStudent(){
        String result = this.questionText;
        for(int i = 0; i<this.answers.size();i++){
            result += "\n   " + (i+1) + ". " + this.answers.get(i).getText();
        }
        System.out.println(result);
    }

    public void showToTeacher(){
        String result = this.questionText;
        for(int i = 0; i<this.answers.size();i++){
            if(this.answers.get(i).getPercent()<10){
                result += "\n" + this.answers.get(i).getPercent() + "   " + (i+1) + ". " + this.answers.get(i).getText();
            }
            else if(this.answers.get(i).getPercent()<100){
                result += "\n" + this.answers.get(i).getPercent() + "  " + (i+1) + ". " + this.answers.get(i).getText();
            }
            else{
                result += "\n" + this.answers.get(i).getPercent() + " " + (i+1) + ". " + this.answers.get(i).getText();
            }
        }
        System.out.println(result);
    }

}
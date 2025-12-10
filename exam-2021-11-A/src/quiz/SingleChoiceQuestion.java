package quiz;

import java.util.ArrayList;

public class SingleChoiceQuestion implements Question{
    private ArrayList<Answer> answers;
    private String questionText;

    public SingleChoiceQuestion(String questionText) {
        if(questionText == null){
            String anomaly = "The question cannot be null!";
            throw new IllegalArgumentException(anomaly);
        }
        if(questionText.isEmpty()){
            String anomaly = "The question cannot be empty!";
            throw new IllegalArgumentException(anomaly);
        }
        this.questionText = questionText;
        this.answers = new ArrayList<Answer>();
    }

    public void addAnswer(Answer a) {
        this.answers.add(a);
    }

    public int nbRightAnswers() {
        int result = 0;
        for (Answer a:this.answers){
            if(a.isRight()){
                result++;
            }
        }
        return result;
    }

    public boolean isValid() {
        return this.nbRightAnswers() == 1;
    }

    public void showToStudent(){
        String result = this.questionText;
        int n=0;
        for(int i = 0;i<this.answers.size();i++){
            n = i+1;
            result += "\n   " + n + ". " + this.answers.get(i).getText(); 
        }
        System.out.println(result);
    }

    public void showToTeacher(){
        String result = this.questionText;
        int n = 0;
        for(int i = 0;i<this.answers.size();i++){
            n = i+1;
            if(this.answers.get(i).isRight()){
                result += "\n-> " + n + ". " + this.answers.get(i).getText(); 
            }
            else{
                result += "\n   " + n + ". " + this.answers.get(i).getText(); 
            }     
        }

        System.out.println(result);
    }

}
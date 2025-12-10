package quiz;

public class MultipleChoiceQuestion extends SingleChoiceQuestion {
    
    public MultipleChoiceQuestion(String questionText) {
        super(questionText);
    }

    public boolean isValid() {
        if(super.nbRightAnswers() >=2){
            return true;
        } 
        return false;
    }

    @Override
    public void showToTeacher(){
        super.showToTeacher();
    }
}

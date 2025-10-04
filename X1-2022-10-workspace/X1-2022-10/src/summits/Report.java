package summits;

public class Report {
    private String description;
    private int difficultyLevel;

    public Report(String description, int level){
        this.description=description;
        if (level<1){
            this.difficultyLevel=1;
        }
        else if(level>4){
            this.difficultyLevel=4;
        }
        else{
            this.difficultyLevel=level;
        }
    }

    public int getDifficultyLevel(){
        return this.difficultyLevel;
    }

    public String toString(){
        return this.description + "(" + this.difficultyLevel + "/4)";
    }
}
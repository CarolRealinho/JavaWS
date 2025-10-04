package summits;

import java.util.ArrayList;

public class Summit {
    private ArrayList<Report> reports;
    private String name;
    private int altitude;

    public Summit(String name, int altitude){
        this.altitude = altitude;
        this.name = name;
        this.reports = new ArrayList<Report>();
    }

    public void addReport(Report report){
        this.reports.add(report);
    }

    public String getName(){
        return this.name;
    }

    public double meanDifficultyLevel(){
        if(this.reports.isEmpty()){
            return Double.NaN;
        }
        double sum = 0;
        int counter = 0;
        for(int i=0;i<this.reports.size();i++){
            sum += this.reports.get(i).getDifficultyLevel();
            counter++;
        }
        
        return sum/counter;
    }

    public String toString(){
        String result = this.name + ", " + this.altitude + "m, " + this.reports.size() + " rapports d'ascension";
        if(this.reports.isEmpty()){
            result += ", aucun rapport d'ascension";
        }
        else{
            result +=", " + this.meanDifficultyLevel() + "/4 difficulté moyenne";
        }

        return result;
    }
}

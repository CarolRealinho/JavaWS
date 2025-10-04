package counter;

import java.util.ArrayList;
import java.util.TreeMap;

public class WordCounter {
    private TreeMap<String,Integer> wordCounts;

    public WordCounter(){
        this.wordCounts = new TreeMap<String,Integer>();
    }

    public void parse(ArrayList<String> words){
        for(String s:words){
            if(this.wordCounts.containsKey(s)){
                this.wordCounts.put(s, this.wordCounts.get(s)+1);
            }
            else{
                this.wordCounts.put(s, 1);
            }
        }
    }

    public int getCount(String word){
        if(this.wordCounts.containsKey(word)){
            return this.wordCounts.get(word);
        }
        return 0;
    }

    public String toString(){
        if(this.wordCounts.isEmpty()){
            return null;
        }
        String result = "{ ";
        int counter = 0;
        for(String s: this.wordCounts.keySet()){
            if(counter==this.wordCounts.size()-1){
                result += s + "=" +this.wordCounts.get(s) + " }";
            }
            else{
                result += s + "=" +this.wordCounts.get(s) + ", ";
            }
            counter++;
        }
        return result;
    }
}

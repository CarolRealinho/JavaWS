package summits;

import java.util.HashMap;

public class SummitCollection {
    private HashMap<String,Summit> summits;

    public SummitCollection(){
        this.summits = new HashMap<String,Summit>();
    }

    public void add(Summit summit){
        this.summits.put(summit.getName(), summit);
    }

    public Summit get(String name){
        if(this.summits.containsKey(name)){
            return this.summits.get(name);
        }
        return null;
    }
}

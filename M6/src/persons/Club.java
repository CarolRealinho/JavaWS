package persons;

import java.util.TreeMap;

public class Club {
    private String name;
    private TreeMap<String,Person> members;
    
    public Club(String name){
        this.name = name;
        this.members = new TreeMap<String,Person>();
    }

    public void enroll(Person person){
        if(!this.members.containsKey(person.getName())){
            this.members.put(person.getName(), person);
        }
    }

    public double meanAge(){
        if(members.isEmpty()){
            return Double.NaN;
        }
        double age = 0;
        for(Person p: members.values()){
            age+=p.getAge();
        }
        return age/members.size();
    }

    public void display(){
        String result = this.name + ", ";
        for(String p: members.keySet()){
            result += p + ", ";
        }

        System.out.println(result + this.meanAge());
    }


}

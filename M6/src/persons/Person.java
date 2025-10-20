package persons;

public class Person extends Object {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return this.name + " : " + this.age + " ans";
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if(!(obj instanceof Person)){
            return false;
        }
        Person person = (Person) obj;
        return this.name.equals(person.getName()) && this.age == person.getAge();
    }

    public void display(){
        System.out.println(this.toString() + ", " + super.toString());
    }
}
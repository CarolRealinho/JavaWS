package persons2;

public class Teacher extends Person {
    private String specialty;

    public Teacher(String name, int age, String specialty){
        super(name, age);
        this.specialty = specialty;
    }

    public String getSpecialty(){
        return this.specialty;
    }

    public String toString(){
        return "Prof. " + this.name + ", " + this.specialty;
    }
}

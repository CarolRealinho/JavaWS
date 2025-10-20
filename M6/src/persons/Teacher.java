package persons;

public class Teacher extends Person {
    private String specialty;

    public Teacher(String name, int age, String specialty){
        super(name, age);
        this.specialty = specialty;
    }

    public String getSpecialty(){
        return this.specialty;
    }

    public boolean equals(Object obj){
        if (obj==this) {
            return true;
        }
        if (!(obj instanceof Teacher)) { 
            return false; 
        }
        Teacher teacher = (Teacher) obj;

        return this.specialty.equals(teacher.getSpecialty()) && this.getName().equals(teacher.getName()) && this.getAge() == teacher.getAge();
    }

    public String toString(){
        return "Prof. " + this.getName() + ", " + this.specialty;
    }
}
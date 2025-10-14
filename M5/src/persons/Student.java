package persons;

public class Student extends Person {
    private String promo;

    public Student(String name, int age, String promo){
        super(name, age);
        this.promo = promo;
    }

    public String getPromo(){
        return this.promo;
    }

    public String toString(){
        return super.toString() + ", " + this.promo;
    }
}

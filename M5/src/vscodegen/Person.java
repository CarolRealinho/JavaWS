package vscodegen;

public class Person {
    private String nome;
    private int age;

    /**
     * Define the name and age of the person
     * 
     * @param name
     * @param age
     */
    public Person(String name, int age) {
        this.nome = name;
        this.age = age;
    }

    /**
     * Get the name of the person
     * 
     * @return
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Get the age of the person
     * 
     * @return
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Return a string with the name and age of the person
     * 
     */
    @Override
    public String toString() {
        return 
            " name='" + nome + "'" +
            ", age='" + age + "'" ;
    }
    
    /*
     * Print this person infos
     * 
     */
    public void display(){
        System.out.println(this);
    }
}

    

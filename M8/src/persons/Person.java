package persons;

public class Person {
   private String name;
   private int age;

   public Person(String name, int age) {
    if(name instanceof String){
        this.name = name;
    }
    else{
        String anomaly = name + " is not a name";
        throw new IllegalArgumentException(anomaly);  
    }
    if(age<0){
        String anomaly = age + " age cannot be less than 0";
        throw new IllegalArgumentException(anomaly);
    }
    this.age = age;
   }

   // @Override uncomment this leads to a compilation error
   public String getName() {
      return name;
   }

   public int getAge() {
      return age;
   }

   public void display() {
      System.out.println(super.toString());
      System.out.println(this.toString());
   }

   @Override
   public String toString() {
      return name + " : " + age + " ans";
   }

   @Override
   public boolean equals(Object o) {
      if (o == this)
         return true;
      if (!(o instanceof Person)) {
         return false;
      }
      Person person = (Person) o;
      // return name.equals(person.name) && age == person.age;
      return name == person.name && age == person.age;
   }

}

package persons;

public class PersonsMain {
    public static void main(String[] args) {
        Person person = new Person("Asterix", 32);
        Object object = new Object();
        System.out.println(person.getClass());
        System.out.println(Integer.toHexString(person.hashCode()));
        System.out.println(person.toString());
        System.out.println(object.toString());

        person.display();
    }
}

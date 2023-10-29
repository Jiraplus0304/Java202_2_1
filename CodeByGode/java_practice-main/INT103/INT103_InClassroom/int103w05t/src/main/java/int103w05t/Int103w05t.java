package int103w05t;

import collection.Group;
import human.*;
import school.*;

public class Int103w05t {

    public static void main(String[] args) {
        //testPerson();
        testGroup();
    }
    static void testPerson() {
        var p0 = new Person(Gender.MALE,"Smith","Johnson");
        var p1 = new Person(Gender.OTHER,"Jame","Simpson");
        var p2 = new Person(Gender.FEMALE,"Samantha","Albert");
        System.out.println("p0: " + p0);
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
    }
    static void testGroup() {
        var g = new Group<Person>();
        var p0 = new Person(Gender.MALE,"Smith","Johnson");
        var s1 = new Student(Gender.OTHER,"Jame","Simpson",Level.JUNIOR);
        var s2 = new Student(Gender.FEMALE,"Valentine","Rose",Level.FRESHMAN);
        var p3 = new Person(Gender.FEMALE,"Samantha","Albert");
        System.out.println("Add p3: " + g.add(p3));
        System.out.println("Add s2: " + g.add(s2));
        System.out.println("Add p0: " + g.add(p0));
        System.out.println("Add s1: " + g.add(s1));
        System.out.println("Listing g: " + g);
        System.out.println("Sorting g: " + g.sort());
        System.out.println("Sorting g by firstname: " + g.sort(Person.FIRSTNAME_COMPARATOR));
        System.out.println("Sorting g by lastname: " + g.sort(Person.LASTNAME_COMPARATOR));
    }
}

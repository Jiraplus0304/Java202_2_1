package int103w06t;

import collection.Group;
import human.Person;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class Int103w06t {

    public static void main(String[] args) {
        //testPerson();
        //testGroup();
        testAssignment();
    }
    static void testAssignment() {
        var p0 = new Person("Kavin","Smith");
        var p1 = new Person("Albert","Dole");
        var p2 = new Person("Kavin","Johnson");
        var p3 = new Person("Albert","Johnson");
        var p4 = new Person("Steve","Smith");
        var g = new Group<Person>();
        g.add(p4); g.add(p2); g.add(p3); g.add(p0); g.add(p1);
        System.out.println("Group: " + g);
        
        //1. sort g by reverse lastname , then reverse id
        System.out.println("Sorted G: " + g.sort(
                Comparator.comparing(Person::getLastname).reversed()
                //Person.BY_LASTNAME.reversed()
                        .thenComparing(
                                Comparator.comparingInt(Person::getId).reversed())));
        
        //2. find a person whose id % 3 == 2
        System.out.println("Find Person whose id % 3 == 2: " + g.find(p -> p.getId() % 3 == 2));
        
        //3. find a person whose firstname contains e and lastname does not contain o 
        Predicate<Person> fne = p -> p.getFirstname().contains("e");
        Predicate<Person> lno = p -> p.getLastname().contains("o");
        System.out.println("Find Person whose FN+e and LN-o: " 
                + g.find(fne.and(lno.negate())));
    }
    static void testPerson() {
        var p0 = new Person("First","One");
        var p1 = new Person("Second","One");
        var p2 = new Person("Fifth", "One");
        var p3 = new Person("Forth", "Four");
                
        System.out.println("p0: " + p0);
        System.out.println("p1: " + p1);
        System.out.println("p0.CompareTo(p1): " + p0.compareTo(p1));
        var ps = new Person[] {p0, new Person("Third","One"), p2, p1, p3};
        for (Person p : ps) System.out.println("ps: " + p);

        Arrays.sort(ps);
        for (Person p : ps) System.out.println("sorted ps: " + p);
        
        Arrays.sort(ps,Comparator.reverseOrder());
        for (Person p : ps) System.out.println("sorted ps reversely: " + p);
        
        Arrays.sort(ps, Person.BY_LASTNAME.thenComparingInt(Person::getId));
        for (Person p : ps) System.out.println("sorted ps BY LASTNAME,ID : " + p);

        Arrays.sort(ps,Comparator.comparing(Person::getFirstname));
        for (Person p : ps) System.out.println("sorted ps BY FIRSTNAME: " + p);
        
        ps[1] = null;
        Arrays.sort(ps,Comparator.nullsFirst(Comparator.naturalOrder()));
        for (Person p : ps) System.out.println("sorted ps (with null): " + p);

        Comparator<Person> ln = (px, py) -> px.getLastname().compareTo(py.getLastname());
        Comparator<Person> fn = (px, py) -> px.getFirstname().compareTo(py.getFirstname());
        Arrays.sort(ps, Comparator.nullsLast(ln.reversed()));
        for (Person p : ps) System.out.println("sorted ps by LASTNAME: " + p);
        
        Arrays.sort(ps, Comparator.nullsLast(ln.thenComparing(fn)));
        for (Person p : ps) System.out.println("sorted ps by LASTNAME,FIRSTNAME: " + p);
    }
    static void testGroup() {
        var p0 = new Person("Kavin","Smith");
        var p1 = new Person("Albert","Dole");
        var p2 = new Person("Kavin","Johnson");
        var p3 = new Person("Albert","Johnson");
        var p4 = new Person("Steve","Smith");
        var g = new Group<Person>();
        g.add(p4); g.add(p2); g.add(p3); g.add(p0); g.add(p1);
        System.out.println("Group: " + g);
        System.out.println("Sorted G: " + g.sort());
        System.out.println("Sorted G by firstname: " + g.sort(Person.BY_FIRSTNAME));
        Predicate<Person> pk = p -> p.getLastname().contains("o");
        System.out.println("Find Person with Lastname contains no o: " + g.find(pk.negate()));
    }
    
}

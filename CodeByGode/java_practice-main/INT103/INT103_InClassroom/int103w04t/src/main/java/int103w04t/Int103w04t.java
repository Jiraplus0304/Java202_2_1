package int103w04t;

import containment.Container;
import human.Person;

public class Int103w04t {

    public static void main(String[] args) {
        testContainer();
    }
    
    static void testContainer() {
        var p0 = new Person("First","Last");
        var p1 = new Person("Second","Final");
        var p2 = new Person("Third","End");
        var p3 = new Person("Forth","Terminal");
        var c = new Container<Person>();
        System.out.println("Add p2: " + c.add(p2));
        System.out.println("Add null: " + c.add(null));
        System.out.println("Add p1: " + c.add(p1));
        System.out.println("Add p3: " + c.add(p3));
        System.out.println("Add p0: " + c.add(p0));
        System.out.println("Listing: " + c);
        System.out.println("Sorting: " + c.sort().toString());
        System.out.println("Sorting by Firstname: " + c.sort(Person.FIRSTNAME_COMAPARATOR).toString());
        
        var it = c.iterator();
        var i2 = c.iterator();
        System.out.println("it 0: " + it.hasNext() + " : " + it.next());
        System.out.println("it 1: " + it.hasNext() + " : " + it.next());
        while (i2.hasNext()) {
            System.out.println("Iterator 2: " + i2.next());
        }
        System.out.println("it 2: " + it.hasNext() + " : " + it.next());
        System.out.println("it 3: " + it.hasNext() + " : " + it.next());
        System.out.println("it 4: " + it.hasNext());
        
    }
}

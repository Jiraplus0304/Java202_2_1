package human;

import java.util.Comparator;
import utility.Util;

public class Person implements Comparable<Person> {
    private static final String BLANK = "BLANK";
    private static int nextId;
    private final int id;
    private final String firstname;
    private final String lastname;
    public static final Comparator<Person> FIRSTNAME_COMAPARATOR = new FirstnameComparator();

    private static class FirstnameComparator implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            if (o1 == null || o1.firstname == null) return 1; 
            if (o2 == null || o2.firstname == null) return -1; 
            return o1.firstname.compareTo(o2.firstname);
        }
    }
    
    public Person(String firstname, String lastname) {
        this.firstname = Util.isValid(firstname) ? firstname : BLANK;
        this.lastname = Util.isValid(lastname) ? lastname : BLANK;
        this.id = nextId++;
    }
    @Override public String toString() {
        return String.format("Person{%d,%s,%s}", id, firstname, lastname);
    }
    @Override public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) return false;
        return this == o || this.id == ((Person) o).id;
    }
    @Override public int compareTo(Person o) { return this.id - o.id; }
}

package int103w03t;

import containment.*;
import human.*;

public class Int103w03t {

    public static void main(String[] args) {
        testContainable();
    }
    static void testContainable() {
        Containable<Person> c = new Container<>();
        System.out.println("Add P5 : " + c.add(new Person(5,"Five")));
        System.out.println("Add null : " + c.add(null));
        System.out.println("Add S2 : " + c.add(new Student(2,"Two","IT")));
        System.out.println("Add P7 : " + c.add(new Person(5,"Seven")));
        System.out.println("Add S3 : " + c.add(new Student(3,"Three","CS")));
        System.out.println("Get P7 : " + c.get(new Person(7,"UNKNOWN")));
        System.out.println("Get S7 : " + c.get(new Student(7,"UNKNOWN","X")));        
        System.out.println("Get S2 : " + c.get(new Student(2,"UNKNOWN","X")));
        System.out.println("Before Sorting: " + c.toString());
        c.sort();
        System.out.println("After Sorting: " + c.toString());
    }
}

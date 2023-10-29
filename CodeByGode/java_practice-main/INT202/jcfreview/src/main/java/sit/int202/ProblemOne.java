package sit.int202;
import java.util.*;

public class ProblemOne {
    public static void main(String[] args) {

        Set<Student> studentSet = new HashSet<>(10, 0.5f);
        studentSet.add(new Student(10001, "Somsri", 3.50));
        studentSet.add(new Student(10002, "Somsak", 3.00));
        studentSet.add(new Student(10009, "Somchai", 3.26));
        studentSet.add(new Student(10007, "Somkiet", 3.25));
        studentSet.add(new Student(10037, "Sirisopaphan", 3.25));
//        for (Student s: studentSet) {
//            System.out.println(s);
//        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println(studentSet);

//        System.out.println("-----------------------------------------------------------------");
//        Set<Student> studentSet2 = new TreeSet<>();
//        studentSet2.add(new Student(10001, "Somsri", 3.50));
//        studentSet2.add(new Student(10002, "Somsak", 3.00));
//        studentSet2.add(new Student(10009, "Somchai", 3.26));
//        studentSet2.add(new Student(10007, "Somkiet", 3.25));
//        studentSet2.add(new Student(10037, "Sirisopaphan", 3.25));
//        for (Student s: studentSet2) {
//            System.out.println(s);
//        }
//
//        List<Student> tmp = studentSet.stream().sorted(Student.COMPARE_BY_GPAX).toList();
//
//        System.out.println("-----------------------------------------------------------------");
//        for (Student s: tmp) {
//            System.out.println(s);
//        }

    }
}

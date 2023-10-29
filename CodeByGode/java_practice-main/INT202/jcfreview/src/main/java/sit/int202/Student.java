package sit.int202;

import lombok.*;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Student implements Comparable<Student>{
    private int id;
    private String name;
    private double gpax;
    public static Comparator<Student> COMPARE_BY_GPAX = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.getGpax() < o2.getGpax()) {
                return 1;
            }else if (o1.getGpax() > o2.getGpax()) {
                return -1;
            }else {
                return o1.getName().compareTo(o2.getName());
            }
        }
    };

    @Override
    public int compareTo(Student o) {
        return this.getId() - o.getId();
    }


    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return id == student.id && Double.compare(student.gpax, gpax) == 0 && Objects.equals(name, student.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, gpax);
//    }
}



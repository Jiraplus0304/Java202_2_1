package sit.int202.sitspacemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter

public class AllStudent {
    List<Student> students = new ArrayList<Student>();

    public void addStudent(Student student){
        this.students.add(student); // add student เข้าไปใน list
    }

    public void removeStudent(Student student){

        this.students.remove(student); // remove student ใน list
    }


}

package sit.int207.sitspacemanagement.model;

import java.util.ArrayList;
import java.util.List;

public class AllStudent {
    private static AllStudent instance;
    private List<Student> students;

    private AllStudent() {
        students = new ArrayList<>();
    }

    public static AllStudent getInstance() {
        if (instance == null) {
            instance = new AllStudent();
        }
        return instance;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public Student getStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getStudents() {
        return students;
    }
}


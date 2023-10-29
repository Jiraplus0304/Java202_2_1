package dev.bestzige.int202sitspacemanagement.services;

import dev.bestzige.int202sitspacemanagement.models.Student;

import java.util.ArrayList;
import java.util.List;

public class AllStudent {
    private List<Student> students = new ArrayList<>();

    public List<Student> getAll() {
        return students;
    }

    public Student get(int id) {
        for(Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    public boolean add(int id, String name, double score) {
        // not null = have student
        // null = don't have student
        Student existingStudent = get(id);

        // ถ้ามีนักเรียนอยู่แล้ว ก็ไม่ต้องทำอะไร
        if(existingStudent != null) {
            return false;
        }

        // ถ้าไม่มีนักเรียนอยู่ ก็เพิ่มนักเรียนเข้าไปในรายชื่อ
        Student student = new Student(id, name, score);
        students.add(student);

        return true;
    }

    public boolean remove(int id) {
        Student existingStudent = get(id);

        // ถ้าไม่มีนักเรียนอยู่ ก็ไม่ต้องทำอะไร
        if(existingStudent == null) {
            return false;
        }

        // ถ้ามีนักเรียนอยู่ ก็ลบนักเรียนออกจากรายชื่อ
        students.remove(existingStudent);

        return true;
    }
}

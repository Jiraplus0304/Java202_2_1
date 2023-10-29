package sit.int202.simple.repositories;

import sit.int202.simple.entities.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectRepository {
    private static List<Subject> subjects;

    public List<Subject> findAll() {
        return subjects;
    }

    public SubjectRepository() {
        initialize();
    }

    private void initialize() {
        subjects = new ArrayList<>(20);
        subjects.add(new Subject("INT 103", "Advanced Programming", 3));
        subjects.add(new Subject("INT 104", "User Experience Design", 3));
        subjects.add(new Subject("INT 105", "Basic SQL", 1));
        subjects.add(new Subject("INT 107", "Computing Platforms Technology", 3));
        subjects.add(new Subject("INT 200", "Data Structures and Algorithms",1));
        subjects.add(new Subject("GEN 121", "Learning and Problem Solving Skills", 3));
        subjects.add(new Subject("INT 100", "IT Fundamentals", 3));
        subjects.add(new Subject("INT 207", "Network I", 3));
    }
}

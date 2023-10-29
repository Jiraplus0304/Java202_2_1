package sit.int202.simple.repositori;

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

    public void initialize() {
        subjects = new ArrayList<>(20);
        subjects.add(new Subject("INT101", "Programming", 3));
        subjects.add(new Subject("INT102", "Database", 3));
        subjects.add(new Subject("INT103", "Web Programming", 3));
        subjects.add(new Subject("INT104", "Data Structure", 3));

    }

}
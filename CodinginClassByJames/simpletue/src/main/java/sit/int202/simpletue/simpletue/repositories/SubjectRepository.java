package sit.int202.simpletue.simpletue.repositories;

import sit.int202.simpletue.simpletue.entities.Subject;

import java.util.ArrayList;
import java.util.List;


public class SubjectRepository {
    private static List<Subject> subjects;

    public List<Subject> findAll(){
        return subjects;
    }

    public SubjectRepository(){
        initialize();
    }

    private void initialize(){
        subjects = new ArrayList<>(20);
        subjects.add(new Subject("INT 100","IT Fundamentals",3));
        subjects.add(new Subject("INT 101","Java Programming I",3));
        subjects.add(new Subject("INT 105","Web Technology",2));
        subjects.add(new Subject("INT 201","Front-end Development",2));
        subjects.add(new Subject("INT 202","Web Programming",2));
        subjects.add(new Subject("INT 207","Network I",3));
    }
}

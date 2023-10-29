package human;

public class Student extends Person {
    private final String curriculum;
    
    public Student(int id, String name, String curriculum) { 
        super(id, name);
        this.curriculum = curriculum;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", cur=" + curriculum + "}";
    }
    
}

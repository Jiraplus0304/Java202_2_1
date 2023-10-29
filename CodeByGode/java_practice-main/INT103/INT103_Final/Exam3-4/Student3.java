import java.io.Serializable;

public class Student3 implements Serializable {
    String studentID;
    String firstName;
    String lastName;
    double score;

    public double getScore() {
        return score;
    }
}

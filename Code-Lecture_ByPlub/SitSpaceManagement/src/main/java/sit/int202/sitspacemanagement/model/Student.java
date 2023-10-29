package sit.int202.sitspacemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter

public class Student {
    public String id;
    public String name;
    public int score;

    public String calculateGrade() {
        return score >= 80 ? "A" : score >= 70 ? "B" : score >= 60 ? "C" : score >= 60 ? "D" : "F";
    }
}

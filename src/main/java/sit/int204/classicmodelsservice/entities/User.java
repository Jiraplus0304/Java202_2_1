package sit.int204.classicmodelsservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    private Integer userId;
    private String name;
    private Integer score;
    private String grade;

    public void calGrade() {
        if (score >= 80) {
            this.grade = "A";
        } else if (score >= 70) {
            this.grade = "B";
        } else if (score >= 60) {
            this.grade = "C";
        } else if (score >= 50) {
            this.grade = "D";
        }else {
            this.grade = "F";
        }

    }


}

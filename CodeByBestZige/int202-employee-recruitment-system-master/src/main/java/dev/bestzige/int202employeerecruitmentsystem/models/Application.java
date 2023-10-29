package dev.bestzige.int202employeerecruitmentsystem.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Application {
    private static int idCounter = 0;
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private JobPosition jobPosition;

    public Application(String firstName, String lastName, String email, JobPosition jobPosition) {
        this.id = idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.jobPosition = jobPosition;
    }
}

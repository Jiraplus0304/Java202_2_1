package dev.bestzige.int202sitspacemanagement.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
    private int id;
    private String name;
    private double score;

    public char getGrade() {
        if (score >= 80) {
            return 'A';
        } else if (score >= 70) {
            return 'B';
        } else if (score >= 60) {
            return 'C';
        } else if (score >= 50) {
            return 'D';
        } else {
            return 'F';
        }
    }
}

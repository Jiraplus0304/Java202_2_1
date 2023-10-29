package com.example.quizapp.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private String title;
    private List<String> options;
    private int correctAnswerIndex;

    public boolean checkAnswer(int selectedIndex){
        return selectedIndex == this.correctAnswerIndex;
    }

}

package com.example.quizapp.model;

import com.example.quizapp.utils.CSVLoader;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizSession {
    private List<Question> questions;
    private int currentQuestionIndex;
    private int correctAnswersCount;

    public void fetchQuestion(){
        this.questions = CSVLoader.getQuestions();
    }
    public void moveToNextQuestion(){
        this.currentQuestionIndex++;
    }
    public boolean isQuizEnded(){
    return currentQuestionIndex == questions.size();
    }

    public void resetQuiz(){
        this.correctAnswersCount = 0;
        this.currentQuestionIndex = 0;
    }
    public void checkCorrectQuestion(int selectedIndex){
      if ( this.questions.get(0).checkAnswer(selectedIndex)) {
          correctAnswersCount++;
      };
    }

}

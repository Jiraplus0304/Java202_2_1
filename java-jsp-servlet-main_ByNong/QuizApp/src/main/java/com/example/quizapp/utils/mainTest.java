package com.example.quizapp.utils;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.QuizSession;

public class mainTest {
    public static void main(String[] args) {
        CSVLoader.loadQuestions();
        QuizSession qs = new QuizSession();
        qs.fetchQuestion();
//        System.out.println(qs.getQuestions());
        System.out.println(qs.getQuestions().size());
        System.out.println("=======================");
        for (Question q : qs.getQuestions()){
            System.out.println(q.getTitle());
            System.out.println(q.getCorrectAnswerIndex());
        }


    }
}

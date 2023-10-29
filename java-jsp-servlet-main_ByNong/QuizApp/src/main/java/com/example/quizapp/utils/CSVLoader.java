package com.example.quizapp.utils;

import com.example.quizapp.model.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Getter
@NoArgsConstructor
public class CSVLoader {
   @Getter
   private static List<Question> questions = new ArrayList<>();

    static {
        loadQuestions();
    }
    public static void loadQuestions() {
        InputStream inputStream = CSVLoader.class.getClassLoader().getResourceAsStream("Data.csv");
        if (inputStream == null) {
            System.out.println("Couldn't find CSV file");
            return;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            String csvSplitBy = "\\|";
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                String questionText = data[0];
//                System.out.println(questionText);
                List<String> options = Arrays.asList(data[1].split(","));
//                System.out.println(options);
                int correctAnswerIndex = Integer.parseInt(data[2]);
//                System.out.println(correctAnswerIndex);
                Question question = new Question(questionText, options, correctAnswerIndex);
                questions.add(question);
            }
            System.out.println("kuy"+questions.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package com.example.quizapp.controller;

import com.example.quizapp.model.QuizSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "QuizController", value = "/QuizController")
public class QuizController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        loadQuiz(request,response);
    }

    private void loadQuiz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(true);
        boolean isNoQuizSessionSession =  httpSession.getAttribute("quizSession") == null;
        QuizSession qs = isNoQuizSessionSession ?  new QuizSession() : (QuizSession) httpSession.getAttribute("quizSession");
        if(isNoQuizSessionSession) qs.fetchQuestion();
//        if(qs.isQuizEnded()) {
//            request.getRequestDispatcher("/result.jsp").forward(request, response);
//            return;
//        }
        var curQuestion =qs.getQuestions().get(qs.getCurrentQuestionIndex());
        httpSession.setAttribute("quizSession",qs);
        httpSession.setAttribute("curQue",curQuestion);
        request.getRequestDispatcher("/quiz.jsp").forward(request,response);
    }

    private void processForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int answer = Integer.parseInt(request.getParameter("options"));
        HttpSession httpSession = request.getSession(false);
        QuizSession qs = (QuizSession) httpSession.getAttribute("quizSession");
        qs.checkCorrectQuestion(answer);
        qs.moveToNextQuestion();
        httpSession.setAttribute("quizSession",qs);
        if(qs.isQuizEnded()) {
            request.getRequestDispatcher("/result.jsp").forward(request, response);
            return;
        }
        loadQuiz(request,response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processForm(request,response);
//        var answer = (request.getParameter("options"));
//        System.out.println(answer);
    }
}
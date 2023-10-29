package com.example.quizapp.controller;

import com.example.quizapp.model.QuizSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "ResetQuizServlet", value = "/ResetQuizServlet")
public class ResetQuizServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        QuizSession qs = (QuizSession) httpSession.getAttribute("quizSession");
        qs.resetQuiz();
        httpSession.setAttribute("quizSession",qs);
        request.getRequestDispatcher("/QuizController").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
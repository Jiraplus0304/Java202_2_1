package sit.int202.simple.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "grade", value = "/EvalGrade")
public class EvalGradeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String score = request.getParameter("score");
        int scoreInt = Integer.parseInt(score);
        String grade = "";
        if (scoreInt >= 80) {
            grade = "A";
        } else if (scoreInt >= 70) {
            grade = "B";
        } else if (scoreInt >= 60) {
            grade = "C";
        } else if (scoreInt >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Grade</h1>");
        out.println("Your score is " + score + "<br>");
        out.println("Your grade is " + grade + "<br>");
        out.println("<br> <a href=\"/simple_war_exploded\">Home </a>");
        out.println("</body></html>");
    }
}
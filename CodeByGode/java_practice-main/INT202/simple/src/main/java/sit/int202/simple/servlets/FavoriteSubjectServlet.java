package sit.int202.simple.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FavoriteSubjectServlet", value = "/favoriteSubject")

public class FavoriteSubjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String[] subjects = request.getParameterValues("favorite_subject");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Your Favorite Subject</h1>");
        out.println("id: " + id + "<br>");
        out.println("name: " + name + "<br>");
        out.println("<h3>Favorite Subject</h3>");
        if (subjects == null) {
            out.println("<br> <a href=\"/simple_war_exploded\">Home </a>");
        } else {
            for (String subject : subjects) {
                out.println("-" + subject + "<br>");
            }
            out.println("<br> <a href=\"/simple_war_exploded\">Home </a>");
        }

//        Map<String,String[]> param = request.getParameterMap();
//        out.println("<br>");
//        out.println("Request Parameter<br>");
//        out.println("Student Id = "+ param.get("id")[0] + "<br>") ;
//        out.println("Student Name = "+ param.get("name")[0] + "<br>") ;
//        out.println("<h3>Favorite Subject</h3>");
//        for (String subject : param.get("favorite_subject")) {
//            out.println("-" + subject + "<br>");
//        }
        out.println("</body></html>");
    }


}
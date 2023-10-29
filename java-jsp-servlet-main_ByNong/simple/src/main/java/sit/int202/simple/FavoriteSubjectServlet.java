package sit.int202.simple;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import  java.util.Map;

@WebServlet(name = "FavoriteSubjectServlet", value = "/FavoriteSubjectServlet")
public class FavoriteSubjectServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req , resp);
    }
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String[] subjects = request.getParameterValues("favorite-Subject");
        System.out.println(id + " " + name);
        for (String s : subjects) {
            System.out.println(s);
        }

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("Favorite Subject" );
        out.println("Student id: " + id + "<br> " );
        out.println("Student Name: " + name + "<br> " );
        out.println("Your Favorite Subject: <br> " );
        for (String Subject : subjects) {
            out.println(Subject +"<br>");
        }
        Map<String ,String[]> param = request.getParameterMap();
        out.println("<hr>");
        out.println("Request Parameter from Map : <br>");
        out.println("Student id: " + param.get("id")[0] + "<br> " );
        out.println("Student Name: " + param.get("name")[0] + "<br> " );
        out.println("Your Favorite Subject: <br> " );
        for (String Subject : param.get("favorite-Subject")) {
            out.println(Subject +"<br>");
        }
        out.println("</body></html>");

    }


    public void destroy() {
    }
}
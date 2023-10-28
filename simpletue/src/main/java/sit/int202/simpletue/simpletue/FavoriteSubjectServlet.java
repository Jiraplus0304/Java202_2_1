package sit.int202.simpletue.simpletue;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "FavoriteSubjectServlet", value = "/favoriteSubject")
public class FavoriteSubjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String subjects[] = request.getParameterValues("subjects");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Your Favorite Subjects ::</h1><hr>");
        out.println("Your Student id : "+id+"<br>");
        out.println("Your Student name : "+name+"<br>");
        out.println("Favorite Subjects: <br>");
        for (String subject:subjects){
            out.println("&nbsp; &nbsp; -"+subject+"<br>");
        }
        out.println("<hr>");
        out.println("<h3>Request parameter using getParameterMap()  ::</h3><hr>");
        Map<String,String[]> map = request.getParameterMap();
        out.println("Your Student id : "+map.get("id")[0]+"<br>");
        out.println("Your Student name : "+map.get("name")[0]+"<br>");
        out.println("Favorite Subjects: <br>");
        for (String subject:map.get("subjects")){
            out.println("&nbsp; &nbsp; -"+subject+"<br>");
        }
        out.println("<hr>");

        out.println("<a href='subjects'>[ Back ] </a>");
        out.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package sit.int202.simple;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "gradeServlet", value = "/gradeServlet")
public class gradeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doProcess(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req , resp);
    }
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String score = request.getParameter("score");
        int score_int = Integer.parseInt(score);
        String result;
        if (score_int >=80 ) {
            result = "A";
        }else if (score_int >=70) {
            result = "B";
        }else if (score_int >=60) {
            result = "C";
        }else{
            result = "F";
        }
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Grage :" + result + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
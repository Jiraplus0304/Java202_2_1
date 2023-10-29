package sit.int202.sitspacemanagement.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.sitspacemanagement.models.AllStudent;

import java.io.IOException;

@WebServlet(name = "AddServlet", value = "/Add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String score = request.getParameter("score");
        HttpSession session =request.getSession();
        AllStudent allStudent = (AllStudent) session.getAttribute("AllStudent");
        if(id.isEmpty() || name.isEmpty() || score.isEmpty()){
            request.setAttribute("messageError", "Enter complete information");
            getServletContext().getRequestDispatcher("/AddRemoveStudent.jsp").forward(request,response);
        }
        int addId = Integer.parseInt(id);
        Double addScore = Double.parseDouble(score);
        if(allStudent != null){
            allStudent.addStudent(addId,name,addScore);
        }else {
            allStudent = new AllStudent();
            allStudent.addStudent(addId,name,addScore);
            session.setAttribute("AllStudent",allStudent);
        }
        session.setAttribute("findAll", allStudent.findAll());
        request.setAttribute("message", "Add Successful");
        getServletContext().getRequestDispatcher("/AddRemoveStudent.jsp").forward(request,response);
    }
}
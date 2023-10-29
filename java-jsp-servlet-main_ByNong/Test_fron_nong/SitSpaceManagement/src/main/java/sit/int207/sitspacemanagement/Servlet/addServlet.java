package sit.int207.sitspacemanagement.Servlet;
import sit.int207.sitspacemanagement.model.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// name = "addServlet" ต้องให้ตรงกับ <form action>
@WebServlet(name = "addServlet", value = "/addServlet")
public class addServlet extends HttpServlet {

    public void init() {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        String studentId = request.getParameter("id");
        String name = request.getParameter("name");
        String scoreString = request.getParameter("score");

        if (studentId.isEmpty() || name.isEmpty() || scoreString.isEmpty()) {
            // Handle the case where any of the input fields is empty
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "มันว่างอยู่นะเติมข้อมูลลงไป (id,name,score)");
            return;
        }

        try {
            int score = Integer.parseInt(scoreString);

            // Create a new student object
            Student student = new Student(studentId, name, score);

            // Add the student to the AllStudent list
//            AllStudent.getInstance().addStudent(student);
            AllStudent.getInstance().addStudent(student);

            // Redirect the user to the "AllData" page
            response.sendRedirect(request.getContextPath() + "/AllData.jsp");
        } catch (NumberFormatException e) {
            // Handle the case where the score is not a valid integer
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Score must be a valid integer.");
        }
    }

    public void destroy() {
    }
}
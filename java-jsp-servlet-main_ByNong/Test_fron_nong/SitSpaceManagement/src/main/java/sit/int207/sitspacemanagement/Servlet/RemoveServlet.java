package sit.int207.sitspacemanagement.Servlet;
import sit.int207.sitspacemanagement.model.AllStudent;
import sit.int207.sitspacemanagement.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;


@WebServlet(name = "RemoveServlet", value = "/RemoveServlet")
public class RemoveServlet extends HttpServlet {


    public void init() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the student ID to be removed from the request parameters
        String studentId = request.getParameter("studentId");

        // Retrieve the student from the AllStudent list using the ID
        Student student = AllStudent.getInstance().getStudentById(studentId);

        if (student != null) { // มันเจอ
            // If the student exists, remove them from the list
            AllStudent.getInstance().removeStudent(student);
            response.sendRedirect(request.getContextPath() + "/AllData.jsp");
        } else {
            // Handle the case where the student is not found
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Student not found.");
        }
    }

    public void destroy() {
    }
}
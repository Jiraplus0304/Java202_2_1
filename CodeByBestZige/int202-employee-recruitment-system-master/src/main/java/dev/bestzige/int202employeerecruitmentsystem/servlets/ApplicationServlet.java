package dev.bestzige.int202employeerecruitmentsystem.servlets;

import dev.bestzige.int202employeerecruitmentsystem.models.Application;
import dev.bestzige.int202employeerecruitmentsystem.models.JobPosition;
import dev.bestzige.int202employeerecruitmentsystem.services.ApplicationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ApplicationServlet", urlPatterns = "/applications")
public class ApplicationServlet extends HttpServlet {
    ApplicationService applicationService = new ApplicationService();

    @Override
    public void init() {
        applicationService.loadData();
    }

    @Override
    public void destroy() {
        applicationService.saveData();
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("applications", applicationService.getApplications());
        request.setAttribute("jobPositions", JobPosition.values());
        request.getRequestDispatcher("/applications.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "apply":
                    String firstName = req.getParameter("firstName");
                    String lastName = req.getParameter("lastName");
                    String email = req.getParameter("email");
                    String jobPosition = req.getParameter("jobPosition");
                    if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || jobPosition.isEmpty()) {
                        req.setAttribute("error", "Please fill in all fields");
                        break;
                    }
                    applicationService.addApplication(
                            new Application(firstName, lastName, email, JobPosition.valueOf(jobPosition))
                    );
                    break;
                case "delete":
                    String password = req.getParameter("password");
                    if (!password.equals("1234")) {
                        req.setAttribute("error", "Invalid password");
                        break;
                    }
                    int id = Integer.parseInt(req.getParameter("id"));
                    applicationService.removeApplication(id);
                    break;
            }
        }

        processRequest(req, resp);
    }
}

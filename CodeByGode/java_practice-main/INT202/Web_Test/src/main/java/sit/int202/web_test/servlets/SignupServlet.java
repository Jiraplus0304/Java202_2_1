package sit.int202.web_test.servlets;

import jakarta.persistence.Access;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.web_test.entities.Accounts;

import java.io.IOException;

@WebServlet(name = "SignupServlet", value = "/signup_Servlet")
public class SignupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("loguser");
        String email = request.getParameter("logemail");
        String password = request.getParameter("logpass");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        Accounts accounts = new Accounts();
        accounts.setId("5");
        accounts.setUsername(username);
        accounts.setPassword(password);
        accounts.setEmail(email);
        em.getTransaction().begin();
        em.persist(accounts);
        em.getTransaction().commit();
        em.close();
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
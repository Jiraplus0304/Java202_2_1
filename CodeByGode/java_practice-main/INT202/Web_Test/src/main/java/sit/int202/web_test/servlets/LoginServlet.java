package sit.int202.web_test.servlets;
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

@WebServlet(name = "LoginServlet", value = "/login_Servlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("loguser");
        String upass = request.getParameter("logpass");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        for(Accounts account : em.createQuery("select a from Accounts a", Accounts.class).getResultList()) {
            if (account.getUsername().equals(uname) && account.getPassword().equals(upass)) {
                getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
            }
        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
//        Accounts account = em.find(Accounts.class, "1");
//        if (account != null && account.getPassword().equals(upass)) {
//            getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
//        } else {
//            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
//        }
    }
}

package sit.int202.bookstore.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SelectBookServlet", value = "/SelectBookServlet")
public class SelectBookServlet extends HttpServlet {

    public void init() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] selectedBooks = request.getParameterValues("selectedBooks");

        if (selectedBooks != null) {
            List<String> historyBooks = (List<String>) request.getSession().getAttribute("historyBooks");

            if (historyBooks == null) {
                historyBooks = new ArrayList<>();
                request.getSession().setAttribute("historyBooks", historyBooks);
            }

            for (String book : selectedBooks) {
                historyBooks.add(book);
            }
        }

        response.sendRedirect(request.getContextPath() + "/selectBook.jsp");
    }

    public void destroy() {
    }
}
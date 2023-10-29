package sit.int202.bookstore.servlet;
import sit.int202.bookstore.model.Book;
import sit.int202.bookstore.model.BookCatalog;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;


@WebServlet(name = "addBook", value = "/addBook")
public class AddBookServlet extends HttpServlet {

    public void init() {
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String year = req.getParameter("year");

        if (title.isEmpty() || author.isEmpty() || year.isEmpty()) {

            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "มันว่างอยู่นะเติมข้อมูลลงไป (title,author,year)");
            return;
        }

        Book book = new Book(title, author, year);
        BookCatalog.getInstance().addBook(book);
        resp.sendRedirect(req.getContextPath() + "/bookList.jsp");
    }

    public void destroy() {
    }
}
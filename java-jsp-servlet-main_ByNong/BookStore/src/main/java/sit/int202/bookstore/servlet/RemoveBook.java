package sit.int202.bookstore.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.bookstore.model.Book;
import sit.int202.bookstore.model.BookCatalog;

import java.io.IOException;
;

@WebServlet(name = "RemoveBook", value = "/RemoveBook")
public class RemoveBook extends HttpServlet {

    public void init() {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        Book book = BookCatalog.getInstance().getBookByTitle(title);

        if (book !=null){
            BookCatalog.getInstance().removeBook(book);
            resp.sendRedirect(req.getContextPath()+"/bookList.jsp");
        }else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,"ไม่พบหนังสือที่จะลบ");
        }
    }

    public void destroy() {
    }
}
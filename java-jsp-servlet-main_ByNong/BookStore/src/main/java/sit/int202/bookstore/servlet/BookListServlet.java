package sit.int202.bookstore.servlet;
import jakarta.servlet.ServletException;
import sit.int202.bookstore.model.Book;
import sit.int202.bookstore.model.BookCatalog;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.io.IOException;

@WebServlet(name = "BookListServlet", value = "/BookListServlet")
public class BookListServlet extends HttpServlet {

    public void init() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the bookCatalog from the application scope
        BookCatalog bookCatalog = (BookCatalog) getServletContext().getAttribute("bookCatalog");

        if (bookCatalog == null) {
            bookCatalog = new BookCatalog();
            getServletContext().setAttribute("bookCatalog", bookCatalog);
        }

        List<Book> books = bookCatalog.getBooks();
        request.setAttribute("books", books);
        request.getRequestDispatcher("/bookList.jsp").forward(request, response);
    }

}
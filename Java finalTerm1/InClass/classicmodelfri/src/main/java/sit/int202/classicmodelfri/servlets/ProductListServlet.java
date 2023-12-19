package sit.int202.classicmodelfri.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.classicmodelfri.entities.Product;
import sit.int202.classicmodelfri.repositories.ProductRepository;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductListServlet", value = "/product-list")
public class ProductListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductRepository productRepository = new ProductRepository();
        String pageParam = request.getParameter("page");
        String pageSizeParam = request.getParameter("pageSize");
        int page = pageParam == null ? 1 : Integer.valueOf(pageParam); //default page start at 1
        int pageSize = pageSizeParam == null ? productRepository.getDefaultPageSize() : Integer.valueOf(pageSizeParam); //default page size to 10
        List<Product> productList = productRepository.findAll(page, pageSize);
        request.setAttribute("products", productList);
        request.setAttribute("page", page);
        request.setAttribute("pageSize", pageSize);

        int itemCount = productRepository.countAll();
        request.setAttribute("itemCount", itemCount); //to count page

        int totalPage = itemCount / pageSize + (itemCount % pageSize == 0 ? 0 : 1);//Ex. 107/10=10 pages but 7 item is at page 11
        request.setAttribute("totalPage", totalPage);

        getServletContext().getRequestDispatcher("/product-list.jsp").forward(request, response);

    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
}
 

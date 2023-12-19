package com.example.mycarshop.servlets;

import com.example.mycarshop.entities.Product;
import com.example.mycarshop.repositories.ProductRepository;
import com.mysql.cj.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "SelectProductServlet", value = "/selected-product")
public class SelectProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ProductRepository productRepository = new ProductRepository();
        String productCode = request.getParameter("code");
        Product selectedProduct = productRepository.findProduct(productCode);
        session.setAttribute("selectedProduct",selectedProduct);
        request.getRequestDispatcher("./product-detail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
package com.example.blogproject.controller;

import com.example.blogproject.model.BlogPost;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddPostServlet", value = "/AddPostServlet")
public class AddPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("addPost.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        BlogPost post = new BlogPost(title, content);

        HttpSession session = request.getSession();
        List<BlogPost> posts = (List<BlogPost>) session.getAttribute("posts");
        if (posts == null) {
            posts = new ArrayList<>();
        }
        posts.add(post);
        session.setAttribute("posts", posts);

        response.sendRedirect("viewPosts.jsp");
    }
}
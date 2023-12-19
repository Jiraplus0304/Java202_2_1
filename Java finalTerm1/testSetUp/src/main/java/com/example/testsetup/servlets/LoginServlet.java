package com.example.testsetup.servlets;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.sendError(HttpServletResponse.SC_BAD_GATEWAY);
        getServletContext().getRequestDispatcher("/formLogin.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        char[] usernameArray = username.toCharArray();
        char[] passwordArray = password.toCharArray();


        String correctUser = "poom";
        String correctPass = "123";
        char[] hashCorrectUser = correctUser.toCharArray();
        char[] hashCorrectPass = correctPass.toCharArray();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d, 16, 16);
        String hashCorrectUserName = argon2.hash(2,16,1, hashCorrectUser);
        String HashCorrectPassword = argon2.hash(2,16,1, hashCorrectPass);

        if (username == null || username.trim().length() == 0 || password == null || password.trim().length() == 0) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            boolean isOkUser = argon2.verify(hashCorrectUserName, usernameArray);
            boolean isOkPass = argon2.verify(HashCorrectPassword, passwordArray);
            System.out.println(isOkUser);
            System.out.println(isOkPass);
            if(!isOkPass && !isOkUser){
//                String Error = request.getHeader("Error");
//                response.addHeader("Error", "Username and Password ... try again");
//                System.out.println("Error: " + Error);
                request.setAttribute("Error", "Username and Password do not match. Please try again.");
                getServletContext().getRequestDispatcher("/formLogin.jsp").forward(request,response);
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            } else{
                request.setAttribute("user", username);
                request.setAttribute("password", password);
            }
        }




    }
}
 
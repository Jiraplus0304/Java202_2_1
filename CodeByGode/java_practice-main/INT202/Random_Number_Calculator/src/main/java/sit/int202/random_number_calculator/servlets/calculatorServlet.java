package sit.int202.random_number_calculator.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.random_number_calculator.models.RandomNumber;

import java.io.IOException;

@WebServlet(name = "calculatorServlet", value = "/calculator")
public class calculatorServlet extends HttpServlet {
    private int count = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RandomNumber randomNumber = new RandomNumber();
        session.setAttribute("num1", randomNumber.getNum1());
        session.setAttribute("num2", randomNumber.getNum2());
        session.setAttribute("result",randomNumber.getResult());
        int countTotal = 3 ;
        session.setAttribute("countTotal",countTotal);
        session.setAttribute("count",count);
        getServletContext().getRequestDispatcher("/Calculator.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String answer = request.getParameter("answer");
        int num1 = (int)session.getAttribute("num1");
        int num2 = (int)session.getAttribute("num2");
        int result = (int)session.getAttribute("result");
        int countTotal = (int)session.getAttribute("countTotal");
        if(isNumber(answer)){
            int answerInt = Integer.parseInt(answer);
            if(answerInt == result){
                count++;
                request.setAttribute("message","Correct!");
                if(count == countTotal){
                    request.setAttribute("message","Congratulations! You got all the answers correct! and your score will be reset!");
                    count = 0;
                }
                doGet(request,response);
            }else {
                request.setAttribute("message", "Incorrect!, The correct answer for " + num1 + " + " + num2 + " is " + result + ".");
                doGet(request,response);
            }
        }else {
            request.setAttribute("message", "Invalid input!");
        }
        getServletContext().getRequestDispatcher("/Calculator.jsp").forward(request, response);
    }
    private Boolean isNumber(String str){
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
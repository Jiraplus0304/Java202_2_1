package sit.int202.simple;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "MultiplicationServlet", value = "/multiplication_table")
public class MultiplicationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String number = request.getParameter("number");
        if (number==null || number.length()==0 || ! isNumber(number)) {
            request.setAttribute("error" ,"Invalid number or paramiter!!" );
        }

        request.getRequestDispatcher("multiplication_table.jsp").forward(request,response);
    }

    private static boolean isNumber(String number) {
        for (int i = 0 ; i< number.length() ; i++){
            if (! Character.isDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
 

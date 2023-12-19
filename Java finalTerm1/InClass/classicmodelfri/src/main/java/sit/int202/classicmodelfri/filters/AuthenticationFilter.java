//package sit.int202.classicmodelfri.filters;
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//
//@WebFilter(filterName = "AuthenticationFilter", servletNames = {"OfficeListServlet", "ProductListServlet"})
//public class AuthenticationFilter implements Filter {
//    public void init(FilterConfig config) throws ServletException {
//    }
//
//    public void destroy() {
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        HttpSession session = httpServletRequest.getSession(false);
//        if (session == null || session.getAttribute("user") == null) {
//            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
//        } else {
//            chain.doFilter(request, response);
//        }
//    }
//}

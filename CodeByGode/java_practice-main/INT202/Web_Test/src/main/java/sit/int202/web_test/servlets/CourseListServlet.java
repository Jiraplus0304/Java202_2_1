package sit.int202.web_test.servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.web_test.models.CourseRepository;
import sit.int202.web_test.models.Semester;
import sit.int202.web_test.models.ViewSupport;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "CourseListServlet", value = "/course-list")
public class CourseListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        if(sc.getAttribute("semesters")==null) {
            sc.setAttribute("semesters", Semester.getAllSemesterText());
        }
        getServletContext().getRequestDispatcher("/course_list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (parameterMap.get("semester")==null) {
            doGet(request,response);
            return;
        }
        int semester = Integer.valueOf(parameterMap.get("semester")[0]);
        //request.setAttribute("semesters", Semester.getAllSemesterText());
        request.setAttribute("selectedSemester", semester);
        request.setAttribute("subjects", CourseRepository.getSubjects(semester));
        request.setAttribute("existSubjects", ViewSupport.getExistSubject(semester, request.getSession(false)));
        getServletContext().getRequestDispatcher("/course_list.jsp").forward(request,response);
    }
}

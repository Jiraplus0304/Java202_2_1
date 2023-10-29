package sit.int202.sitspacemanagement;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.sitspacemanagement.model.AllStudent;
import sit.int202.sitspacemanagement.model.Student;

import java.io.IOException;
import java.util.function.Predicate;

@WebServlet(name = "RemoveServlet", value = "/RemoveServlet")
public class RemoveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String input = request.getParameter("id"); // รับ input id

        ServletContext sc1 = getServletContext(); // application scope
        AllStudent data = (AllStudent) sc1.getAttribute("useAll"); // useAll เก็บใน data

//      var matchID = data.getStudents().stream().filter(new Predicate<Student>() { // เก็บค่าที่ id ตรงกันใน matchID
//            @Override
//            public boolean test(Student student) {
//                return input.equals(student.getId()) ; // String คือ Obj เลยใช้ equals()
//            }
//      }).toArray(); // เอาข้อมูล list // stream() เรียกใช้ method iterator //ต้องมี predicate Annonymous fucntion // toArray เพราะเป็น stream type

        var matchID = data.getStudents().stream().filter(student -> student.getId().equals(input)).toArray(); // เปลี่ยน list เป็น collection

        data.removeStudent((Student) matchID[0]); // remove student ID ที่ซ้ำกัน [0] เพราะลบต่าตัวแรกใน array
        sc1.setAttribute("useAll", data); // save ค่า data เรียกใช้ผ่าน useAll
        sc1.setAttribute("removedStatus","Removed Successful"); // กด remove แล้วจะขึ้น Removed Succesful
        request.getRequestDispatcher("/AddRemoveStudent.jsp").forward(request,response); // กดแล้วโยงไปหน้า AddremovedStudent
    }

}

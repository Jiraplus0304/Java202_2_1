package sit.int202.sitspacemanagement;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.sitspacemanagement.model.AllStudent;
import sit.int202.sitspacemanagement.model.Student;

import java.io.IOException;

@WebServlet(name = "AddServlet", value = "/AddServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc1 = getServletContext();
        sc1.removeAttribute("addedStatus"); // เวลาเปลี่ยนกลับจากหน้า allData คำพูด added succesful จะหายไป
        sc1.removeAttribute("removedStatus"); // เวลาเปลี่ยนกลับจากหน้า allData คำพูด removed succesful จะหายไป
        request.getRequestDispatcher("/AddRemoveStudent.jsp").forward(request,response); // กดแล้วโยงไปหน้า AddRemoveStudent
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response); // เรียกใช้ processRequest
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String input1 = request.getParameter("id"); //id //ตั้งค่าให้ตรงกับ name ใน jsp
        String input2 = request.getParameter("name"); //name
        int input3 = Integer.parseInt(request.getParameter("score")); //score (cast) แปลงจาก String เป็น int

        Student std1 = new Student(input1,input2,input3); // สร้าง object เพื่อเก็บค่า input

        ServletContext sc1 = getServletContext(); // จะใช้ ServletContext for ยัดข้อมูลในระดับ application

        if(sc1.getAttribute("useAll") == null) {
            AllStudent astd1 = new AllStudent(); // collection ที่ไว้เก็บ student
            sc1.setAttribute("useAll", astd1); // set ค่า AllStudent ให้กับ application scope เรียกใช้ผ่าน key (useAll),(key,obj)
        }
            AllStudent astd1 = (AllStudent) sc1.getAttribute("useAll"); // cast ค่า แปลงให้ฝั่งขวาเป็น AllStudent
            astd1.addStudent(std1); // เพิ่ม student
            sc1.setAttribute("useAll", astd1); // save ค่า astd1 ใส่ใน useAll // เป็น application scope สามารถเรียกใช้ผ่าน key (key,obj)
            sc1.setAttribute("addedStatus","Added Successful"); //กด add แล้วจะขึ้น Added Successful
        request.getRequestDispatcher("/AddRemoveStudent.jsp").forward(request,response); // กดแล้วโยงไปหน้า AddRemoveStudent

    }

}

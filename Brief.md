If there are address already in use check by lsof -i :8080 through terminal if there is not ur user kill it by kill [PID] then check again and you can use it rn

--- SUMMARY ---
Dependencies -> จะถูกเก็บไว้ใน pom.xml เวลาจะหาใช้ -> \users\ikkew.m2\
WWW -> 1) client = browser [ส่งไปด้วย HTTP Requests] ไป server form URL 2) server = web server -> ตอบกลับด้วย HTTP response ( request(client) , response(server) )
Web Application -> จำเป็นต้องมี application server เพื่อเพิ่ม รับ request + ตอบ response (คุยกับ web server) จะทำเป็น HTML เพื่อส่งไปให้ web server (Ex. JSP file)
App Server -> Web container จะดูแล 1) JSP เขียน html ง่าย และเอา data จาก servlet มาแสดง , 2) Servlet -> รับ request + เขียน html แต่ยาก

"SERVLET" ---> จะเรียกผ่าน URL ทำงานในฝั่ง server , manage by Web Container ซึ่งอาศัย URL Mapping | ทำงานบน Jakarta EE , HTTP request
           ซึ่ง Servlet จะมีการส่ง parameter 2 ตัว -> 1) HttpServletRequest request -> เอา text มาทำเป็น object | 2) HttpServletResponse response -> เขียนผลลัพธ์กลับ
                  % -> บ่งบอกว่าเป็น java ข้างใน | การเรียกไฟล์ servlet มาใช้ -> <a href = "hello-servlet"> ซึ่งเวลาเรียกใช้ต้องอิงจาก ( value = "/hello-servlet" )
           in servlet จะมี method หลักๆ 2 อย่าง -> 1) doget 2) dopost 
           จะมีการ forward data ไป jsp เพื่อส่งกลับ

"JSP Jakarta Servlet Page" ---> ทำงานในฝั่ง server และมี web container คอยจัดการ
                ทำให้เรารวม Static + dynamic ได้ | ภายในไฟล์จะมี JSP syntax , HTML | ใน JSP ต้องใช้ชื่อนี้การอ้าง "Students" -> ตามธรรมเนียมต้องใส่ S เพื่อให้รู้ว่าเป็๋น collection

"HTTP Protocol" : request --> request(post)
"Request Dispatcher" --> include และ forward เป็นวิธีการใช้งานที่เกี่ยวข้องกับ RequestDispatcher เพื่อส่งคำขอ (request) จากหน้าเว็บหนึ่งไปยังอีกหน้าเว็บหนึ่ง โดยส่งข้อมูลข้ามหน้าเว็บได้ด้วยการแชร์ข้อมูล (data sharing) ระหว่างหน้าเว็บที่ส่ง
                         และหน้าเว็บที่รับคำขอ
Forward (RequestDispatcher.forward)
การเปลี่ยนทาง (Forward) จะส่งคำขอจาก Servlet หนึ่งไปยัง Servlet อีกตัวโดยตรง ทำให้การดำเนินการของคำขอเกิดขึ้นใน Servlet ที่ได้รับคำขอล่าสุด โดยหน้าเว็บเริ่มต้นจะไม่สามารถมองเห็นคำขอส่งเข้ามา คำขอจะถูกส่งต่อไปถึง Servlet ใหม่แทนที่จะส่งกลับไปยัง
เบราว์เซอร์
ข้อมูลที่ถูกส่งผ่าน forward จะถูกเก็บอยู่บนหน้าเว็บใหม่ที่ถูกส่งคำขอไป
URL บนเบราวเซอร์จะไม่เปลี่ยนเมื่อมีการ forward

Include (RequestDispatcher.include)
การรวม (Include) จะนำหน้าเว็บใหม่มาใส่ลงในหน้าเว็บเดิม ทำให้ข้อมูลจากหน้าเว็บใหม่ถูกแสดงบนหน้าเว็บเดิมโดยไม่ทำให้ URL เปลี่ยนไปหรือโหลดหน้าเว็บใหม่
ข้อมูลที่ถูกส่งผ่าน include จะถูกแสดงบนหน้าเว็บเดิมที่ส่งคำขอมา
เมื่อการทำงานจบลงที่หน้าเว็บที่ถูกส่งมา การควบคุมจะกลับไปยัง Servlet ที่ส่งคำขอมาและดำเนินการต่อ
--- QUESTION ---
which of the following is exam of jsp tag -> include
A session cookie is --> "delete" <-- when the browser is close
How many container can create JSP Servlet??? = 1 instance
which one is not servlet character -> file extension is (ไฟล์นามสกุลที่ชื่อ -> .svl)
การสร้าง servlet ต้องใช้วิธีใดบ้าง -> doget , dopost
output ใด ที่เอาไว้ใช้เขียนบน browser -> Printwriter
which directory that have to contain web.xml file -> WEB-INF
in cycle servlet , which step invoke DOGET & DOPOST -> Serving Request 
ถ้าคุณเรียกใช้ URL ผิด หรือ URL ที่ไม้่มีไฟล์หรือ servlet จะเป็นอย่างไร -> Page 404
วิธีใดที่ใช้รับข้อมูลสำหรับ text field ในข้อความ string นี้ = request.getParameter("name") -> getParameter("String")
วิธีใดที่ใช้สำหรับการแชร์ตัวแปรหรือ object ระหว่างหลาย page or multiple servlet -> setAttribute(String name , Object Value)

-----------------
วิธีการที่ดีกว่าระหว่าง sendRedirect() และ RequestDispatcher ขึ้นอยู่กับความต้องการของแอปพลิเคชันของคุณและสภาพแวดล้อมการพัฒนาของคุณ:

sendRedirect():
เมื่อใช้: sendRedirect() มักถูกใช้เมื่อคุณต้องการเปลี่ยน URL ทั้งหมดและจะเริ่มคำขอใหม่ในเบราวเซอร์ของผู้ใช้.
เมื่อเหมาะสม: ใช้ sendRedirect() เมื่อคุณต้องการเปลี่ยน URL ทั้งหมดและต้องการสร้าง URL ภายนอกโดเมนปัจจุบัน (ยกตัวอย่างเช่นการนำทางไปยังเว็บไซต์อื่น).
RequestDispatcher:
เมื่อใช้: RequestDispatcher มักถูกใช้เมื่อคุณต้องการแสดงหน้าใหม่ในโดเมนเดียวกันโดยยังคงใช้คำขอ (request) เดิม.
เมื่อเหมาะสม: ใช้ RequestDispatcher เมื่อคุณต้องการแสดงหน้าใหม่โดยไม่ต้องสร้างคำขอใหม่ (ยกตัวอย่างเช่นเมื่อคุณต้องการแสดงหน้าผลลัพธ์หลังจากการกรอกแบบฟอร์ม).
สรุปคือ, sendRedirect() และ RequestDispatcher มีการใช้งานแตกต่างกันและเหมาะกับสถานการณ์ที่แตกต่างกัน. คุณควรเลือกวิธีที่เหมาะสมกับความต้องการของโปรเจกต์และวัตถุประสงค์ของคุณ.
//Redirect
if (username.equals("admin") && password.equals("password")) {
    response.sendRedirect("home.jsp");
} else {
    response.sendRedirect("login.jsp?error=1");
}

--------------------
//RequestDispatcher
if (username.equals("admin") && password.equals("password")) {
    RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
    dispatcher.forward(request, response);
} else {
    response.sendRedirect("login.jsp?error=1");
}


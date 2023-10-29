package exam.main;

import exam.base.Loggable;
import exam.unit.Department;
import exam.unit.School;
import exam.unit.Staff;
import solution.base.OrgUnit;

public class MainOrgTest {
    public static void main(String[] args) {
        testSchool();
        testDepartment();
        testSchoolAsOrgUnit();
        testDepartmentAsLoggable();
        testStaff();
    }

    public static void testSchool(){
        System.out.println("testSchool");
        School school = new School(1,"KMUTT");
        System.out.printf("School: Code: %d ,Name: %s ,Logging:%s ,Balance:%.2f%n"
        ,school.getCode(),school.getName(),school.getLog(),school.getBalance());
        school.earn(1000.0);
        System.out.printf("School: Code: %d ,Name: %s ,Logging:%s ,Balance:%.2f%n"
                ,school.getCode(),school.getName(),school.getLog(),school.getBalance());
        school.spend(500);
        System.out.printf("School: Code: %d ,Name: %s ,Logging:%s ,Balance:%.2f%n"
                ,school.getCode(),school.getName(),school.getLog(),school.getBalance());

    }
    public static void testDepartment(){
        System.out.println("testDepartment");
        Department department = new Department(054,"Phuttinan",new School(1,"KMUTT"));
        System.out.printf("School: Code: %d ,Name: %s ,Logging:%s%n"
                ,department.getCode(),department.getName(),department.getLog());
        department.setSchool(new School(2,"KMUTT2"));
        System.out.printf("School: Code: %d ,Name: %s ,Logging:%s%n"
                ,department.getCode(),department.getName(),department.getLog());
        System.out.println( department.getSchool());

    }
    public static void testSchoolAsOrgUnit(){
        System.out.println("\nTest School as OrgUnit ...");
        solution.unit.School s = new solution.unit.School(1, "SIT");
        System.out.format("School: code[%d] name[%s] balance[%.2f] log[%s]%n", s.getCode(), s.getName(), s.getBalance(), s.getLog());
        s.earn(5_000);
        solution.base.OrgUnit o = s;
        o.setName("School of IT");
        s.spend(2_125);
        ((solution.unit.School) o).earn(10_000);
        System.out.format("OrgUnit: code[%d] name[%s] log[%s]%n", o.getCode(), o.getName(), o.getLog());
        OrgUnit u = new solution.unit.School(2, "School of IT");
        System.out.format("OrgUnit: code[%d] name[%s] log[%s]%n", u.getCode(), u.getName(), u.getLog());
        ((solution.unit.School) u).earn(10_000);
        ((solution.unit.School) u).spend(7_000);
        u.setName("School of Information Technology");
        System.out.format("OrgUnit: code[%d] name[%s] log[%s]%n", u.getCode(), u.getName(), u.getLog());
    }
    public static void testDepartmentAsLoggable(){
        System.out.println("testDepartmentAsLoggable");
        Department department = new Department(054,"Phuttinan",new School(1,"KMUTT"));
        System.out.printf("School: Code: %d ,Name: %s ,Logging:%s%n",department.getCode(),department.getName(),department.getLog());
        Loggable loggable = department ;
        System.out.println("Log: "+loggable.getLog());
        loggable.clearLog();
        System.out.println("Log: "+loggable.getLog());
    }

    public static void testStaff(){
        Staff staff = new Staff(054 ,"Phuttinan" ,"Phaksaweang" , new School(1 ,"KMUTT"));
        System.out.format("Staff: id:%d firsname:%s lastname:%s affiliation:%s%n",
                staff.getId(), staff.getFirstname(), staff.getLastname(), staff.getAffiliation().getName());
        staff.setId(54);
        staff.setFirstname("Phuttinan2");
        staff.setLastname("Phaksaweang2");
        staff.setAffiliation(new School(22, "Digital Innovation"));
        System.out.format("Staff: id:%d firsname:%s lastname:%s affiliation:%s%n",
                staff.getId(), staff.getFirstname(), staff.getLastname(), staff.getAffiliation().getName());
    }
}

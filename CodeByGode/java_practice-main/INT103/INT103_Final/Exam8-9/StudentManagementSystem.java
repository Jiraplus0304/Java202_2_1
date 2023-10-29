import java.util.Scanner;

public class StudentManagementSystem {
    public static void main(String[] args) {
        int option = 0 ;
        School school = new School() ;
        String studentID,firstName,lastName,email,degree ;
        while (option != 5){
            System.out.println("Main Menu");
            System.out.println("1. Add a new student.");
            System.out.println("2. Delete the existing student.");
            System.out.println("3. Display all student details.");
            System.out.println("4. Search a student detail.");
            System.out.println("5. Exit.");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            switch (option){
                case 1 :
                    System.out.print("StudentID:");
                    studentID = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("FirstName:");
                    firstName = scanner.nextLine();
                    System.out.print("LastName:");
                    lastName = scanner.nextLine();
                    System.out.print("Email:");
                    email = scanner.nextLine();
                    System.out.print("Degree:");
                    degree = scanner.nextLine();
                    Student student = new Student(studentID,firstName,lastName,email,degree);
                    school.addStudent(student);
                    break;
                case 2 :
                    System.out.print("RemoveStudentId: ");
                    studentID = scanner.nextLine();
                    scanner.nextLine();
                    school.removeStudent(studentID);
                    System.out.print("Remove");
                    break;
                case 3 :
                    school.displayStudentDetails();
                    break;
                case 4 :
                    System.out.print("Search a student detail Id: ");
                    studentID = scanner.nextLine();
                    scanner.nextLine();
                    school.searchStudent(studentID);
                    System.out.print("Search a student detail");
                    break;
            }
            System.out.println("Exit");
        }
    }

}

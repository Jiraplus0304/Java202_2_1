import java.io.*;
import java.util.Scanner;

public class SerializationTestExam3 {
    public static void main(String[] args) {
        Student3 s = new Student3();
        Scanner scanner = new Scanner(System.in);
        System.out.println("studentID: ");
        s.studentID = scanner.nextLine();
        System.out.println("firstName: ");
        s.firstName = scanner.nextLine();
        System.out.println("lastName: ");
        s.lastName = scanner.nextLine();
        System.out.println("score: ");
        s.score = scanner.nextDouble();
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("exam3.dat"));
            output.writeObject(s);
            output.flush();
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            ObjectInputStream input =new ObjectInputStream(new FileInputStream("exam3.dat"));
            try {
                Student3 s2 =(Student3) input.readObject();
                System.out.println(s.studentID + " " + s.firstName +" " + s.lastName + " " + s.score);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
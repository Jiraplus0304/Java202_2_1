import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("exam1.txt"));
            while (input.hasNext()){
                String stdId = input.nextLine();
                String Name = input.nextLine();
                int Age = input.nextInt();
                int cm = input.nextInt();
                double kg = input.nextDouble();
                System.out.println("รหัสนศ.:" + stdId + " ชื่อ: " + Name + " อายุ: " + Age + " ส่วนสูง: " + cm + " น้ำหนัก: " + kg);
            }
            input.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

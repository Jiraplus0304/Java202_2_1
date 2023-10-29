import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterTest {
    public static void main(String[] args) {
        PrintWriter output = null;
        try {
            output = new PrintWriter("exam1.txt");
            output.println("65130500054");
            output.println("Phuttinan Phaksaweang");
            output.println("20");
            output.println("175");
            output.println("120");
            output.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionalProgramming {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Got","baimon","big","Gode");

        // lamda expression
        names.stream().filter(name -> name.startsWith("G")).forEach(System.out::println);

        // sort by method
        names.sort(String::compareToIgnoreCase);
        System.out.println(names);

        List<Integer> nameLengths = names.stream().map(name -> name.length()).toList();
        System.out.println(nameLengths);

        List<Integer> nameLengthsBasic = new ArrayList<>();
        for (String name: names) {
            nameLengthsBasic.add(name.length());
        }
        System.out.println(nameLengthsBasic);
    }

}

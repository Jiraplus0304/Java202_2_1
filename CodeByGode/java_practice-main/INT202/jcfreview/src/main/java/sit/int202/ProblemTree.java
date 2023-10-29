package sit.int202;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ProblemTree {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("data.txt");
        Scanner scanner = new Scanner(file);
        Map<String, List<Integer>> map = new TreeMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            StringTokenizer stk = new StringTokenizer(line, " .,?()");
            int wordIndex = 0;
            while (stk.hasMoreTokens()) {
                String word = stk.nextToken();
                if (map.get(word)== null){
                    map.put(word,new LinkedList<Integer>());
                }
                map.get(word).add(++wordIndex);
            }
        }
        scanner.close();
        for(Map.Entry<String,List<Integer>> entry : map.entrySet()){
            System.out.print(entry.getKey() + "(" + entry.getValue().size() + ")");
            for(Integer position : entry.getValue()){
                System.out.print("@" + position + "  ");
            }
            System.out.println();
        }

    }
}

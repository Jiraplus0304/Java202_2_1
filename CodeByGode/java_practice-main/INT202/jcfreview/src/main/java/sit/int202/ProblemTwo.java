package sit.int202;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class ProblemTwo {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();

        int data[] = {1, 2, 3, 5, 8, 7, 9, 6, 4};
        int x = 6;
        for (int i = 0; i < data.length; i++) {
            int v = data[i];
            int key = x - v;
            if(map.get(key) == null){
                map.put(v,i);
            }else {
                System.out.println("("+ i +"," + map.get(key) + ")");
                map.put(v,i);
            }
        }
    }


}

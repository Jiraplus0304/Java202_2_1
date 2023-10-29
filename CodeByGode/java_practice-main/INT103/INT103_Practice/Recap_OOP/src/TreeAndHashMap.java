import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeAndHashMap {
    public static void main(String[] args) {
        System.out.println("HashMap");
        hashMapTest();

        System.out.println("TreeMap");
        treeMapTest();

        System.out.println("Grade");
        System.out.println(gradeCal(71));

    }

    public static String gradeCal(int score){
        TreeMap<Integer,String> grades =new TreeMap<>();
        grades.put(0,"F");
        grades.put(50,"D");
        grades.put(60,"C");
        grades.put(70,"B");
        grades.put(80,"A");
        return grades.floorEntry(score).getValue();
    }
    private static void hashMapTest(){
        HashMap<String,Integer> maps = new HashMap<>();
        maps.put("A",100);
        maps.put("X",1000);
        maps.put("O",20);
        maps.put("C",90);

        for(Map.Entry<String,Integer> entry : maps.entrySet()){
            String key = entry.getKey();
            int value = entry.getValue();

            System.out.println("Key: " + key);
            System.out.println("Value: "+ value);
            System.out.println("----------------");
        }
    }

    private static void treeMapTest(){
       TreeMap<String,Integer> maps = new TreeMap<>();
        maps.put("A",100);
        maps.put("X",1000);
        maps.put("O",20);
        maps.put("C",90);

        for(Map.Entry<String,Integer> entry : maps.entrySet()){
            String key = entry.getKey();
            int value = entry.getValue();

            System.out.println("Key: " + key);
            System.out.println("Value: "+ value);
            System.out.println("----------------");
        }
    }

}

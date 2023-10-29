package sit.int202;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProblemFour {
    public static void main(String[] args) {
        int[] data = {8,2,3,7,8,8,7,4,7,4,4,2,2,3,8,2,7,3,3,8};
        Map<Integer,List<Integer>> map= new TreeMap<>();
        for (int i =0 ; i < data.length ; i++){
            if(map.get(data[i]) == null){
                map.put(data[i],new LinkedList<Integer>());
            }
            map.get(data[i]).add(i);
        }

        int maxEntryKey = 0;
        int maxEntryValue = 0;
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            if (entry.getValue().size() >= maxEntryValue){
                maxEntryKey = entry.getKey();
            }
        }
        System.out.print(maxEntryKey +"("+map.get(maxEntryKey).size()+")"+ ": " + map.get(maxEntryKey));
    }

}

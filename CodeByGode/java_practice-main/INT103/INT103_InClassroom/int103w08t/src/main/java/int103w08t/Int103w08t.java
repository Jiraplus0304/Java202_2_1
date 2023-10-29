/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package int103w08t;

import collection.ImCollection;
import java.util.List;

/**
 *
 * @author Student
 */
public class Int103w08t {

    public static void main(String[] args) {
        testCollection();
    }
    static void testCollection() {
        var c = new ImCollection<String>(new String[] {"One","Two","Three","Four"});
        System.out.println("contains Two: " + c.contains("Two"));
        System.out.println("contains One and Four: " + c.containsAll(List.of("Four","One")));
        System.out.println("contains Two and Five: " + c.containsAll(List.of("Two","Five")));

        var a = c.toArray();
        System.out.print("c.toArray():");
        for (Object o : a) System.out.print(" " + ((String) o).charAt(0));
        System.out.println();

        var s = c.toArray(new String[0]);
        System.out.print("c.toArray(String[]):");
        for (String str : s) System.out.print(" " + str.charAt(1));
        System.out.println();
        
        var f = c.toArray(String[]::new);
        System.out.print("c.toArray(IntFunction<String>):");
        for (String str : s) System.out.print(" " + str.charAt(2));
        System.out.println();
        
        // external iterator
        System.out.print("Iterator:");
        for (String string : c) {
            if (string.contains("e")) System.out.print(" " + string);
        }
        System.out.println();
        
        // internal iterator
        System.out.print("Stream:");
        c.stream()
                .filter(str->str.contains("e"))
                .map(String::length)
                .forEachOrdered(st->System.out.print(" " + st));
        System.out.println();
        
        
    }
}

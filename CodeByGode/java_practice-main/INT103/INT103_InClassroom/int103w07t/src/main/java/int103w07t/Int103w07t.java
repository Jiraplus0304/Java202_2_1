package int103w07t;

public class Int103w07t {

    public static void main(String[] args) {
        testImIterable();
    }
    static void testImIterable() {
        Iterable<String> it = 
                new ImIterable<>(new String[] {"One", "Two", "Three"});
        System.out.println("HasNext-Next:");
        var i = it.iterator();
        while (i.hasNext()) System.out.println("value: " + i.next());
        System.out.println("For-Each Loop:");
        for (var s : it) System.out.println("value: " + s);
        System.out.println("Funcitonal Style: forEach");
        it.forEach(System.out::println);
        it.forEach(s -> System.out.println("value: " + s));
        var j = it.iterator();
        System.out.println("ForEachRemaining:");
        System.out.println("First: " + j.next());
        j.forEachRemaining(System.out::println);
    }
}

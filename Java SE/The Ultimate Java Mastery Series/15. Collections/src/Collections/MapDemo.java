package Collections;

import java.util.HashMap;
import java.util.Map;

// Java: Maps
// C#: Dictionary
// Python: Dictionary
// JavaScript: Objects
// var person = {name: "a"}
public class MapDemo {
    public static void show() {
        var c1 = new Customer("a", "e1");
        var c2 = new Customer("b", "e2");
        Map<String, Customer> map = new HashMap<>();
        map.put(c1.getEmail(), c1);
        map.put(c2.getEmail(), c2);

        System.out.println(map.getOrDefault("e10", new Customer("c", "")));
        System.out.println(map.containsKey("e10"));
        map.replace("e1", new Customer("a++", "e1"));
        System.out.println(map);

        for (var entry : map.entrySet())
            System.out.println(entry);
    }
}

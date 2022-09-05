package Collections;

import java.util.*;

public class SetDemo {
    public static void show() {
        Collection<String> collection = new ArrayList<>();
        Collections.addAll(collection, "c", "a", "b", "c", "c");
        Set<String> set = new HashSet<>(collection);
        System.out.println(set);

        Set<String> set2 = new HashSet<>(Arrays.asList("c", "a+", "b", "c", "c"));
        System.out.println(set2);


        // Union
        set.addAll(set2);
        System.out.println(set);
        System.out.println(set2);

        // Intersection
        set.retainAll(set2);
        System.out.println(set);
        System.out.println(set2);

        // Difference
        set.removeAll(set2);
        System.out.println(set);
        System.out.println(set2);

    }
}

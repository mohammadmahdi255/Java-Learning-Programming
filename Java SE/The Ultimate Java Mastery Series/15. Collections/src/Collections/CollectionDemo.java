package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class CollectionDemo {
    public static void show() {
        Collection<String> collection = new ArrayList<>();
        Collections.addAll(collection, "a", "b", "c");
        collection.remove("a");
        System.out.println(collection);
        System.out.println(collection.size());
        System.out.println(collection.contains("b"));
        System.out.println(collection.isEmpty());
        System.out.println(Arrays.toString(collection.toArray()));
        System.out.println(Arrays.toString(collection.toArray(new String[0])));
        collection.clear();

        Collection<String> other = new ArrayList<>(collection);
        System.out.println(collection == other);
        System.out.println(collection.equals(other));
    }
}

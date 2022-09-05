package Collections;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static  void show() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");
        list.set(0, "a+");
        list.add(0, "!");
        list.remove(0);
        list.remove("b");
        System.out.println(list.indexOf("c"));
        System.out.println(list.lastIndexOf("a"));
        System.out.println(list);
        System.out.println(list.subList(0, 2));
    }
}

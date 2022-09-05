import Collections.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CollectionDemo.show();
        System.out.println();
        ListDemo.show();
        System.out.println();

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("baba", "email3"));
        customers.add(new Customer("amin", "email"));
        customers.add(new Customer("sara", "email2"));
//        Collections.sort(customers, new EmailComparator());
        customers.sort(new EmailComparator());
        System.out.println(customers);

        QueueDemo.show();
        System.out.println();
        SetDemo.show();
        System.out.println();
        MapDemo.show();
    }
}

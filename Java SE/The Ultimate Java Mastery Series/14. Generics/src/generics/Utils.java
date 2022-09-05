package generics;

public class Utils {
    public static <T extends Comparable<T>> T max(T first, T second) {
        return first.compareTo(second) < 0 ? second : first;
    }

    public static <K, V> void print(K key, V value) {
        System.out.println(key + " = " + value);
    }

    public static void printUser(User user) {
        System.out.println(user);
    }

    // wildcard
    // class CAP#1 extends User {}
    // so we can add CAP#1 or any subtype of it.
    // but here we can't add new instance to users
    // because we don't access to CAP#1 or any subtype of it
    // we can't add new instance
    public static void printUsers(GenericList<? extends User> users) {
        var x = users.get(0);
//        users.add(new User(144));
    }

    // wildcard
    // class ? is parent of User class {}
    // so we can add user or any subtype of it.
    public static void printObjects(GenericList<? super User> users) {
        var x = users.get(0);
        users.add(new User(11));
        users.add(new Instructor(55));
    }

    // Generic method
    // we can't add new instance
    public static <E extends User> void printUsersGeneric(GenericList<E> users) {
        users.add((E) new Instructor(44));
        users.add((E) new Instructor(144));
        users.add((E) new User(214));
    }
}

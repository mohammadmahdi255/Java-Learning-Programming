import generics.*;

public class Main {

    public static void main(String[] args) {
	    var list = new List();
	    list.add(1);
	    list.add("String");
		System.out.println(list.get(1));
		System.out.println(list);

		var genericList = new GenericList<Integer>(10);
		genericList.add(12);
		genericList.add(10);
		System.out.println(genericList.get(0));
		System.out.println(genericList);

		var user1 = new User(10);
		var user2 = new User(20);

		if(user1.compareTo(user2) < 0)
			System.out.println("LT");
		else if (user1.compareTo(user2) == 0)
			System.out.println("EQ");
		else
			System.out.println("GT");

		System.out.println(Utils.max(1, 4));
		System.out.println(Utils.max(user1, user2));
		Utils.print(10, "Hello");

		User user = new Instructor(10);
		Utils.printUser(user);

		var instructor = new GenericList<Instructor>(10);
		Utils.printUsers(instructor);
		Utils.printUsersGeneric(instructor);
		System.out.println(instructor);

		var users = new GenericList<User>(10);
		Utils.printObjects(users);
		System.out.println(users);

		for (var e: genericList) {
			System.out.println(e);
		}
	}
}

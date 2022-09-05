package generics;

public class Instructor extends User {
    public Instructor(int points) {
        super(points);
    }

    @Override
    public int compareTo(User other) {
        return super.compareTo(other);
    }
}

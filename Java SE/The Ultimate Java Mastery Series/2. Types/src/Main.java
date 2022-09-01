import java.awt.*;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // byte
        // short
        // int
        // long
        // float
        // double
        // char
        // boolean
        byte age = 30;
        long viewsCount = 3_123_456_789L; // can be lower case L
        float price = 10.99F; // can be lower case F
        char letter = 'A';
        boolean isEligible = false;

        System.out.printf("%d %d %f %c %b %n", age, viewsCount, price, letter, isEligible);

        Date now = new Date();
        System.out.println(now);

        // primitive type
        byte x = 1;
        byte y = x;
        x = 2;
        System.out.println(y);

        // reference type
        Point point1 = new Point(1, 1);
        Point point2 = point1;
        point1.x = 2;
        System.out.println(point2.getLocation());
    }
}

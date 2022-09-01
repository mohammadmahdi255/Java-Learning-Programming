import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String result = NumberFormat.getPercentInstance().format(0.1);
        System.out.println(result);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Age and Name: ");
        byte age = scanner.nextByte();
        String name = scanner.nextLine().trim();
        System.out.println("Your are " + name + " and Yor age is " + age);
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter an integer: ");
        int number = scanner.nextInt();

        System.out.format("The number is: %d", number);
    }
}

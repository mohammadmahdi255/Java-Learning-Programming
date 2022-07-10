import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a double number: ");
        double x = scanner.nextDouble();

        int counter = 0;
        final int counterMax = 3;
        while (x >= 1 && counter < counterMax) {
            System.out.printf("%f\n", x);
            x /= 2;
            counter++;
        }
    }
}

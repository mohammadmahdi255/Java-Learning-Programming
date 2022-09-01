import java.util.Scanner;

public class Console {

    private static final Scanner scanner = new Scanner(System.in);

    public static double readNumber() {
        return scanner.nextDouble();
    }

    public static double readNumber(String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = readNumber();
            if (min <= value && value <= max)
                return value;
            System.out.println("Enter a number between " + min + " and " + max + ".");
        }
    }

}

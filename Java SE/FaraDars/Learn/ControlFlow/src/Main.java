import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int number = scanner.nextInt();

        if(number % 2 == 0) {
            System.out.format("%d is an even number.%n", number);
        } else {
            System.out.format("%d is an odd number.%n", number);
        }

        String type = (number % 2 == 0) ? "Even" : "Odd";
        System.out.format("The number %d is an %s number%n", number, type);

        System.out.println("Please enter an integer [1 to 7]: ");
        int weekDay = scanner.nextInt();

        String day = switch (weekDay) {
            case 1 -> "Saturday";
            case 2 -> "Sunday";
            case 3 -> "Monday";
            case 4 -> "Tuesday";
            case 5 -> "Wednesday";
            case 6 -> "Thursday";
            case 7 -> "Friday";
            default -> "Not Exist";
        };

        System.out.format("the day #%d in week is: %s", weekDay, day);

    }

}

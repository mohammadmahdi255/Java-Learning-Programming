import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int number = scanner.nextInt();

//        if(number % 2 == 0) {
//            System.out.format("%d is an even number.", number);
//        } else {
//            System.out.format("%d is an odd number.", number);
//        }

        String type = (number % 2 == 0) ? "Even" : "Odd";
        System.out.format("The number %d is an %s number", number, type);

    }

}

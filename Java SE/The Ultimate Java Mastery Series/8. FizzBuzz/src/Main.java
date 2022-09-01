import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number: ");
        int number = scanner.nextInt();

        String result = "";
        result += (number % 5 == 0) ? "Fizz" : "";
        result += (number % 3 == 0) ? "Buzz" : "";
        result = (result.equals("")) ? String.valueOf(number) : result;

        System.out.println(result);
    }
}

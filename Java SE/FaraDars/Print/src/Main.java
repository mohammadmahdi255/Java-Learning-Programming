public class Main {
    public static void main(String[] args) {
        int number = 12345;

        // %[-|0][+][,][l]d
        System.out.format("the number is %d.%n", number);
        System.out.format("the number is %08d.%n", number);
        System.out.format("the number is %8d.%n", number);
        System.out.format("the number is %-8d.%n", number);
        System.out.format("the number is %-+8d.%n", number);
        System.out.format("the number is %,8d.%n", number);
        System.out.format("the number is %,d.%n", number);
        System.out.format("the number is %+,8d.%n", number);
        System.out.format("the number is % 0,8d.%n", number);

        double pi = Math.PI + 10000;
        // %[-|0][+][,][l][.][m]f
        System.out.format("pi = %f%n", pi);
        System.out.format("pi = %.2f%n", pi);
        System.out.format("pi = %-8.2f%n", pi);
        System.out.format("pi = %-+8.2f%n", pi);
        System.out.format("pi = %-+,8.2f%n", pi);
        System.out.format("pi = %08.2f%n", pi);
        System.out.format("pi = %-8.4f%n", pi);
        System.out.format("pi = %-8.2f%n", pi);
        System.out.format("pi = %*.*f%n", 8, 2, pi);
    }
}

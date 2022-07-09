public class Main {

    public static void main(String[] args) {

        int a, b, c;
        a = 10;
        b = a++ * a--;
        c = ++a;

        System.out.format("a = %d\n", a);
        System.out.format("b = %d\n", b);
        System.out.format("c = %d\n", c);

    }

}

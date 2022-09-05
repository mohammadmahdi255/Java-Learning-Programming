package lambdas;

import java.util.List;
import java.util.function.*;

public class LambdaDemo {

    public static final String postfix = "-";

    public void print(String message) {}

    public LambdaDemo(String message) {}

    public static void show() {
        String prefix = "-";
        greet(System.out::println);
        greet(message -> System.out.println(prefix + message + postfix));
        greet((String message) -> {
            System.out.println(prefix + message);
        });
        var printer = new Printer() {
            public final String field = "!!";

            @Override
            public void print(String message) {
                System.out.println(this + prefix + message + field + postfix);
            }
        };
        greet(printer);
        var demo = new LambdaDemo("------");
        greet(demo::print);
        greet(LambdaDemo::new);
        System.out.println(printer.field);
        Printer x = System.out::println;

        System.out.println("====================");

        List<Integer> list = List.of(1, 2, 3, 4);

        // Imperative Programming (for, if/else, switch/case)
        for (var item : list) {
            System.out.println(item);
        }
        System.out.println("====================");

        // Declarative Programing
        list.forEach(System.out::println);

        System.out.println("====================");

        List<String> lst = List.of("a", "b", "c");
        Consumer<String> print = System.out::println;
        Consumer<String> printUpperCase = item -> System.out.println(item.toUpperCase());

        lst.forEach(print.andThen(printUpperCase).andThen(print));
        System.out.println("====================");
        lst.forEach(print.andThen(printUpperCase.andThen(print)));
        System.out.println("====================");

        Supplier<Double> getRandom = Math::random;
        System.out.println(getRandom.get());

        Function<String, Integer> map = String::length;
        System.out.println(map.apply("Sky"));

        Function<String, String> replaceColon = str -> str.replace(":", "=");
        Function<String, String> addBraces = str -> "{" + str + "}";

        // Declarative Programing
        var result = replaceColon
                .andThen(addBraces)
                .apply("key:value");
        // reverse
        result = addBraces.compose(replaceColon).apply("key:value");
        System.out.println(result);

        Predicate<String> isLongerThanFive = str -> str.length() > 5;
        System.out.println(isLongerThanFive.test("sky"));
        System.out.println(isLongerThanFive.test("static"));

        Predicate<String> hasLeftBrace = str -> str.startsWith("{");
        Predicate<String> hasRightBrace = str -> str.endsWith("}");

        var condition = hasLeftBrace.and(hasLeftBrace.negate()).test(result);
        System.out.println(condition);

        BinaryOperator<Integer> add = Integer::sum;
        Function<Integer, Integer> square = n -> n * n;
        System.out.println(add.andThen(square).apply(1, 2));

        UnaryOperator<Integer> unarySquare = n -> n * n;
        UnaryOperator<Integer> increment = n -> n + 1;
        System.out.println(increment.andThen(square).apply(1));
    }

    private static void greet(Printer printer) {
        printer.print("Hello World");
    }

}

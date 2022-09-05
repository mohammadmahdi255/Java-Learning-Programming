package streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class CreateStreamsDemo {
    public static void show() {
        int[] numbers = {1, 2, 3};
        Arrays.stream(numbers).forEach(System.out::println);

        Stream.of(1, 2, 3, 4, 5).forEach(System.out::println);
        var infiniteStream = Stream.generate(Math::random);
        infiniteStream.limit(3).forEach(System.out::println);
        System.out.println("====================");

        var infiniteStreamIterate = Stream.iterate(1, n -> n + 1);
        infiniteStreamIterate.limit(10).forEach(System.out::println);
        System.out.println("====================");
    }
}

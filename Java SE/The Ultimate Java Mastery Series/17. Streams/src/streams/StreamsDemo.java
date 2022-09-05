package streams;

import java.util.Collection;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamsDemo {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 25),
                new Movie("d", 20)
        );

        AtomicInteger count = new AtomicInteger();
        movies.forEach(movie -> {
            if (movie.getLikes() > 10) count.getAndIncrement();
        });
        System.out.println(count.get());
        System.out.println("====================");

        // Functional Programming
        var result = movies.stream().filter(movie -> movie.getLikes() > 10).count();
        System.out.println(result);
        System.out.println("====================");

        var stream = movies.stream();
        stream.map(Movie::getTitle).forEach(System.out::println);
        System.out.println("====================");

        movies.stream()
                .mapToInt(Movie::getLikes)
                .forEach(System.out::println);
        System.out.println("====================");

        Stream.of(List.of(1, 2, 3), List.of(4, 5, 6))
                .forEach(System.out::println);
        System.out.println();

        Stream<List<Number>> listStream = Stream.of(List.of(1, 2, 3), List.of(4, 5, 6));
        Function<Collection<Number>, Stream<Double>> fun = list -> Stream.of(1.2, 1.3, 1.4);
        var tempStream = listStream.<Number>flatMap(fun);
        tempStream.forEach(System.out::println);
        System.out.println("====================");

        movies.stream()
                .dropWhile(m -> m.getLikes() < 23)
                .forEach(movie -> System.out.println(movie.getTitle()));
        System.out.println("====================");

    }
}

package streams;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("c", 25, Genre.THRILLER),
                new Movie("b", 15, Genre.ACTION),
                new Movie("a", 10, Genre.ACTION),
                new Movie("e", 10, Genre.COMEDY),
                new Movie("d", 40, Genre.COMEDY)
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

        movies.stream()
                .sorted(Comparator.comparing(Movie::getTitle))
                .forEach(System.out::println);

        System.out.println("====================");

        movies.stream()
                .map(Movie::getLikes)
                .distinct()
                .forEach(System.out::println);

        System.out.println("====================");

        movies.stream()
                .filter(m -> m.getLikes() > 10)
                .peek(m -> System.out.println("filtered: " + m.getTitle()))
                .map(Movie::getTitle)
                .peek(t -> System.out.println("mapped: " + t))
                .forEach(System.out::println);
        System.out.println("====================");

        stream = movies.stream();
        System.out.println(stream.findAny());
//        System.out.println(stream.findFirst());

        System.out.println(movies.stream()
                .max(Comparator.comparing(Movie::getLikes)));

        System.out.println("====================");

        var sum = movies.stream()
                .map(Movie::getLikes)
                .reduce(0, Integer::sum);
        System.out.println(sum);
        System.out.println("====================");

        var data = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.toMap(Movie::getTitle, Function.identity()));
        System.out.println(data);

        var num = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.summarizingLong(Movie::getLikes));
        System.out.println(num);
        result = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .mapToLong(Movie::getLikes).sum();
        System.out.println(result);
        var concat = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .map(Movie::getTitle)
                .collect(Collectors.joining(", "));
        System.out.println(concat);
        System.out.println("====================");

        Map<?, ?> map = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre));
        System.out.println(map);

        map = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre, Collectors.toSet()));
        System.out.println(map);

        map = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre, Collectors.counting()));
        System.out.println(map);

        map = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,
                        Collectors.mapping(Movie::getTitle,
                                Collectors.joining(" - "))));
        System.out.println(map);
        System.out.println("====================");

        map = movies.stream()
                .collect(Collectors.partitioningBy(
                        m -> m.getLikes() > 10,
                        Collectors.mapping(Movie::getTitle,
                                Collectors.joining("-"))));
        System.out.println(map);
        System.out.println("====================");

        var primitiveStream = IntStream.range(1, 5);
        primitiveStream.forEach(System.out::println);
    }
}

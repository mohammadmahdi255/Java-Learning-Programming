package executors;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFuturesDemo {
    public static void show() {
        var future = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate(6_000);
            return "Done";
        });

        future.thenRun(() -> System.out.println(Thread.currentThread()));

        future.thenAcceptAsync(result -> {
            System.out.println(Thread.currentThread());
            System.out.println(result);
        });

        future.thenApply(String::hashCode).thenAccept(System.out::println);

//        try {
//            var result = future.exceptionally(ex -> "Ok").get();
//            System.out.println("result " + result);
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }

        CompletableFuture.supplyAsync(() -> "email")
                .thenCompose(email -> CompletableFuture.supplyAsync(() -> email + " playlist"))
                .thenAccept(System.out::println);

        var first = CompletableFuture
                .supplyAsync(() -> "20USD")
                .thenApply(str -> Integer.parseInt(str.replace("USD", "")));
        var second = CompletableFuture.supplyAsync(() -> 0.9);
        first.thenCombine(second, (x, y) -> x * y)
                .thenAccept(System.out::println);

        first = CompletableFuture.supplyAsync(() -> 1);
        second = CompletableFuture.supplyAsync(() -> 2.1);
        var third = CompletableFuture.supplyAsync(() -> 3);

        var all = CompletableFuture.allOf(first, second, third);
        all.thenRun(() -> System.out.println("All tasks completed successfully"));

        first = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate(3_000);
            return 20;
        });
        third = CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture.anyOf(first, third).thenAccept(System.out::println);

        first = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate(3_000);
            return 14;
        });

        first.completeOnTimeout(14, 1, TimeUnit.SECONDS)
                .thenAccept(System.out::println);
    }

    public static void showFlight() {
        var start = LocalTime.now();

        var flightService = new FlightService();
        var result = flightService
                .getQuotes()
                .map(future -> future.thenAccept(System.out::println)).toList();

        CompletableFuture.allOf(result.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    var duration = Duration.between(start, LocalTime.now());
                    System.out.println("Retrieved all quotes in " + duration.toMillis() + "ms");
                });

    }
}

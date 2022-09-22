package executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void show() {
        var executor = Executors.newFixedThreadPool(2);
        try {
            System.out.println(executor.getClass().getName());
            for (int i = 0; i < 10; i++) {
                var future = executor.submit(() -> {
                    System.out.println(Thread.currentThread().getName());
                    LongTask.simulate(3_000);
                    return 2;
                });
                System.out.println(future.get());
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
        }
    }
}

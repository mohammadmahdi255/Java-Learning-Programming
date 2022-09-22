package concurrency;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadDemo {
    public static void show() {
        System.out.println(Thread.currentThread().getName());

        List<Thread> threads = new ArrayList<>();
        List<DownloadFileTask> tasks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            var task = new DownloadFileTask();
            tasks.add(task);
            Thread thread = new Thread(task);
            thread.start();
            threads.add(thread);
        }

        threads.forEach(ThreadDemo::join);

        var sum = tasks.stream()
                .mapToInt(m -> m.getStatus().getTotalBytes()).sum();
        System.out.println(sum);

        System.out.println("===========");

        var status = new DownloadStatus();
        var thread1 = new Thread(new DownloadFileTask(status));
        var thread2 = new Thread(() -> {
            while (!status.isDone()) {
                synchronized (status) {
                    try {
                        status.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("1");
                }
                System.out.println("2");
            }
            System.out.println(status.getTotalBytes());
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        Collection<Integer> collection = Collections.synchronizedCollection(new ArrayList<>());
        thread1 = new Thread(() -> {
            collection.addAll(Arrays.asList(1, 2, 3, 4));
        });
        thread2 = new Thread(() -> {
            collection.addAll(Arrays.asList(5, 6, 7, 8));
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(collection);

        // use partitioning technics
        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "a");

    }

    private static void join(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

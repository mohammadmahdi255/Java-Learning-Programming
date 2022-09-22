import executors.CompletableFuturesDemo;

public class Main {
    public static void main(String[] args) {
//        var service = new MailService();
//        service.sendAsync();
//        CompletableFuturesDemo.show();
//        System.out.println("Hello World");
//        ExecutorDemo.show();
        CompletableFuturesDemo.showFlight();
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
package concurrency;

public class DownloadFileTask implements Runnable{

    private final DownloadStatus status;

    public DownloadFileTask() {
        this.status = new DownloadStatus();
    }

    public DownloadFileTask(DownloadStatus status) {
        this.status = status;
    }

    public DownloadStatus getStatus() {
        return status;
    }
    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread().getName());
        for (int i = 0; i < 1_000_000; i++) {
            if (Thread.currentThread().isInterrupted()) return;
            status.incrementTotalBytes();
        }

        status.done();
        synchronized (status) {
            status.notify();
        }

        System.out.println("Download complete: " + Thread.currentThread().getName());
    }
}

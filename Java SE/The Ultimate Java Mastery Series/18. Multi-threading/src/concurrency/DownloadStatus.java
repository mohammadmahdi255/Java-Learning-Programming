package concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    private volatile boolean isDone;
    private final LongAdder totalBytes = new LongAdder();
    private final AtomicInteger totalFiles = new AtomicInteger();
    private final Lock totalBytesLock = new ReentrantLock();
    private final Object totalFilesLock = new Object();
    public int getTotalBytes() {
        return totalBytes.intValue();
    }
    public void incrementTotalBytes() {
//        totalBytesLock.lock();
//        try {
//            totalBytes.incrementAndGet();
//        } finally {
//            totalBytesLock.unlock();
//        }
        totalBytes.increment();
    }
    public void incrementTotalFiles() {
        synchronized (totalFilesLock) {
            totalFiles.incrementAndGet();
        }
    }
    public int getTotalFiles() {
        return totalFiles.get();
    }
    public boolean isDone() {
        return isDone;
    }
    public void done() {
        isDone = true;
    }
}

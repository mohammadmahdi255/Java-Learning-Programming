package com.mytube;

public class VideoProcessor {
    private VideoEncoder encoder;
    private VideoDatabase database;
    private NotificationService notificationService;

    public VideoProcessor(VideoEncoder encoder, VideoDatabase database, NotificationService notificationService) {
        setEncoder(encoder);
        setDatabase(database);
        setNotificationService(notificationService);
    }

    public void process(Video video) {
        encoder.encode(video);
        database.store(video);
        notificationService.notify(video.getUser());
    }

    private void setEncoder(VideoEncoder encoder) {
        this.encoder = encoder;
    }

    private void setDatabase(VideoDatabase database) {
        this.database = database;
    }

    private void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
}


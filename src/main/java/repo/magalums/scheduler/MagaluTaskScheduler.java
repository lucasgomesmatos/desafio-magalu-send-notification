package repo.magalums.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import repo.magalums.service.NotificationService;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;


@Component
public class MagaluTaskScheduler {

    private static final Logger logger = LoggerFactory.getLogger(MagaluTaskScheduler.class);

    private final NotificationService notificationService;

    public MagaluTaskScheduler(final NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void checkTasks() {
        logger.info("Running scheduled task");

        var dateTime = LocalDateTime.now();
        this.notificationService.checkAndSendNotifications(dateTime);

    }
}

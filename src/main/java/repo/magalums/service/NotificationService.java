package repo.magalums.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import repo.magalums.controller.dto.ScheduleNotificationDto;
import repo.magalums.entity.Notification;
import repo.magalums.entity.Status;
import repo.magalums.repository.NotificationRepository;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(final NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void scheduleNotification(final ScheduleNotificationDto dto) {
        this.notificationRepository.save(dto.toNotification());
    }

    public Optional<Notification> getNotifications(final Long id) {
        return this.notificationRepository.findById(id);
    }


    @Transactional
    public void cancelNotification(final Long id) {
       var notification = this.getNotifications(id);
        notification.ifPresent(value -> value.setStatus(Status.Values.CANCELED.toStatus()));
    }

    @Transactional
    public void checkAndSendNotifications(LocalDateTime dateTime) {
        var notifications = this.notificationRepository.findByStatusInAndDateTimeBefore(
                List.of(Status.Values.PENDING.toStatus(), Status.Values.ERROR.toStatus()),
                dateTime
        );

        sendNotification(notifications);
    }

    private static void sendNotification(List<Notification> notifications) {
        notifications.forEach(notification -> {
            // TODO - Send notification
            notification.setStatus(Status.Values.SUCCESS.toStatus());
        });
    }
}


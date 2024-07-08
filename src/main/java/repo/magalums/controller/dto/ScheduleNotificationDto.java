package repo.magalums.controller.dto;

import repo.magalums.entity.Channel;
import repo.magalums.entity.Notification;
import repo.magalums.entity.Status;

import java.time.LocalDateTime;

public record ScheduleNotificationDto(
        LocalDateTime dateTime,
        String destination,
        String message,
        Channel.Values channel
) {

    public Notification toNotification() {
        return new Notification(
                dateTime,
                destination,
                message,
                channel.toChannel(),
                Status.Values.PENDING.toStatus()
        );
    }
}

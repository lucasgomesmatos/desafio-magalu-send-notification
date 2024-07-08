package repo.magalums.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repo.magalums.controller.dto.ScheduleNotificationDto;
import repo.magalums.entity.Notification;
import repo.magalums.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(final NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Void> scheduleNotification(@RequestBody ScheduleNotificationDto dto) {
        notificationService.scheduleNotification(dto);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Notification> getNotifications(@PathVariable Long id) {
        var notification = notificationService.getNotifications(id);

        return notification.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> cancelNotification(@PathVariable Long id) {
        notificationService.cancelNotification(id);
        return ResponseEntity.noContent().build();
    }
}

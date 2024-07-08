package repo.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import repo.magalums.entity.Notification;
import repo.magalums.entity.Status;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByStatusInAndDateTimeBefore(List<Status> status, LocalDateTime dateTime);
}

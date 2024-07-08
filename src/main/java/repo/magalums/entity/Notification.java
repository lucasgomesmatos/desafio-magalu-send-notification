package repo.magalums.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;

    private String destination;

    private String message;

    public Notification() {
    }

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    public Notification(
            final LocalDateTime dateTime,
            final String destination,
            final String message,
            final Channel channel,
            final Status status
    ) {

        this.dateTime = dateTime;
        this.destination = destination;
        this.message = message;
        this.channel = channel;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDestination() {
        return destination;
    }

    public String getMessage() {
        return message;
    }

    public Channel getChannel() {
        return channel;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

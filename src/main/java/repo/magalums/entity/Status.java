package repo.magalums.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_status")
public class Status {

    @Id
    private Long id;

    private String description;

    public Status() {
    }

    public Status(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public enum Values {
        PENDING(1L, "Pending"),
        SUCCESS(2L, "Success"),
        ERROR(3L, "Error"),
        CANCELED(4L, "Canceled");

        private final Long id;
        private final String description;

        Values(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        public Status toStatus() {
            return new Status(this.id, this.description);
        }
    }
}

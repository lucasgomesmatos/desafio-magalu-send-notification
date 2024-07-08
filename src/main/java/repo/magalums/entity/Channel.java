package repo.magalums.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_channel")
public class Channel {

    @Id
    private Long id;

    private String description;

    public Channel() {
    }

    public Channel(Long id, String description) {
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
        EMAIL(1L, "Email"),
        SMS(2L, "SMS"),
        PUSH(3L, "Push"),
        WHATSAPP(4L, "WhatsApp");

        private final Long id;

        private final String description;

        Values(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        public Channel toChannel() {
            return new Channel(this.id, this.description);
        }
    }
}

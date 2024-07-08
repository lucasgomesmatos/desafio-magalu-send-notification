package repo.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import repo.magalums.entity.Channel;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}

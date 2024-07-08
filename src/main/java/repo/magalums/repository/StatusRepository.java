package repo.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import repo.magalums.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
}

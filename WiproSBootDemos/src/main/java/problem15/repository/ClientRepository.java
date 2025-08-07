package problem15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import problem15.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

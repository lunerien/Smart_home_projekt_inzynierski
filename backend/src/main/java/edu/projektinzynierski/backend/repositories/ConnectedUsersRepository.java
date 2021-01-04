package edu.projektinzynierski.backend.repositories;

import edu.projektinzynierski.backend.models.ConnectedUsers;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectedUsersRepository extends CrudRepository<ConnectedUsers, Integer> {
  Optional<ConnectedUsers> findByUuid(UUID uuid);
}

package edu.projektinzynierski.backend.repositories;

import edu.projektinzynierski.backend.models.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
  Optional<User> findByUuid(UUID uuid);

  Boolean existsByUuid(UUID uuid);

  Boolean existsByLogin(String login);

  Optional<User> findByLogin(String login);
}

package edu.projektinzynierski.backend.repositories;

import edu.projektinzynierski.backend.models.UserLocation;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLocationGroupRepository extends CrudRepository<UserLocation, Integer> {
  Optional<UserLocation> findByUuid(UUID uuid);
}

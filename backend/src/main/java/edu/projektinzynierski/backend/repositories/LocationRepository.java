package edu.projektinzynierski.backend.repositories;

import edu.projektinzynierski.backend.models.Location;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location,Integer> {
  Optional<Location> findByUuid(UUID uuid);
}

package edu.projektinzynierski.backend.repositories;

import edu.projektinzynierski.backend.models.LocationGroup;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationGroupRepository extends CrudRepository<LocationGroup, Integer> {
  Optional<LocationGroup> findByUuid(UUID uuid);

}

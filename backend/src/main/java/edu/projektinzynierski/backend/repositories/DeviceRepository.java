package edu.projektinzynierski.backend.repositories;

import edu.projektinzynierski.backend.models.Device;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Integer> {
  Optional<Device> findByUuid(UUID uuid);
}

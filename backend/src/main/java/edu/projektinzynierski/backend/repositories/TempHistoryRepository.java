package edu.projektinzynierski.backend.repositories;

import edu.projektinzynierski.backend.models.TempHistory;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempHistoryRepository extends CrudRepository<TempHistory, Integer> {
  Optional<TempHistory> findByUuid(UUID uuid);

  List<TempHistory> findAllByDevice_Uuid(UUID uuid);
}

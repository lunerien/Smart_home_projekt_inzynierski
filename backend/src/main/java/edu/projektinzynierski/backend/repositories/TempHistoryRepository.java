package edu.projektinzynierski.backend.repositories;

import edu.projektinzynierski.backend.models.TempHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempHistoryRepository extends CrudRepository<TempHistory, Integer> {}

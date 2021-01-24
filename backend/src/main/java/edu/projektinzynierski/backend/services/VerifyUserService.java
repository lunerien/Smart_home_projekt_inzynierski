package edu.projektinzynierski.backend.services;

import edu.projektinzynierski.backend.repositories.UserRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerifyUserService {
  private final UserRepository userRepository;

  public Boolean userExists(UUID userUUID) {
    return userRepository.existsByUuid(userUUID);
  }
}

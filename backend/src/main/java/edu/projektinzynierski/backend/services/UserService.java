package edu.projektinzynierski.backend.services;

import edu.projektinzynierski.backend.exceptions.WrongUserRegisterException;
import edu.projektinzynierski.backend.models.User;
import edu.projektinzynierski.backend.models.accessControll.Level;
import edu.projektinzynierski.backend.repositories.UserRepository;
import edu.projektinzynierski.backend.services.requests.UserLoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public void registerUser(UserLoginRequest request) {
    if (!userRepository.existsByLogin(request.getLogin()) && !request.getPassword().isEmpty()) {
      User user =
          User.builder()
              .login(request.getLogin())
              .level(Level.USER)
              .password(passwordEncoder.encode(request.getPassword()))
              .build();
      userRepository.save(user);
    } else {
      throw new WrongUserRegisterException();
    }
  }

  public String loginUser(UserLoginRequest request) {
    User user =
        userRepository.findByLogin(request.getLogin()).orElseThrow(WrongUserRegisterException::new);
    if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
      return user.getUuid().toString();
    } else {
      throw new WrongUserRegisterException();
    }
  }
}

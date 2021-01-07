package edu.projektinzynierski.backend.models.accessControll;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Level {
  USER(0),
  ADMIN(1);
  private final int level;
}

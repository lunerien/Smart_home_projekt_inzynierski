package edu.projektinzynierski.backend.models.accessControll;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PermissionLevel {
  OWNER(0),
  EDITOR(1),
  VIEWER(3);
  private final Integer level;
}

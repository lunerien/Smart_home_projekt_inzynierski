package edu.projektinzynierski.backend.models;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class UserLocation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID uuid;

  @ManyToOne(optional = false)
  private User user;

  @ManyToOne(optional = false)
  private Location location;

  @Column(nullable = false)
  private Integer permissionLevel;
}

package edu.projektinzynierski.backend.models;

import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Location {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID uuid;

  private String locationName;

  @ManyToOne
  private Location locationGroup;

  @OneToMany(mappedBy = "location")
  private List<Device> devicesInLocation;
}

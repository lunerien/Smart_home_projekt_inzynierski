package edu.projektinzynierski.backend.models;

import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LocationGroup {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(insertable = false, updatable = false, columnDefinition = "serial")
  @GeneratedValue()
  private UUID uuid;

  @Column(nullable = false)
  private String groupName;

  @OneToMany(mappedBy = "locationGroup")
  private List<Location> locationsInGroup;

  @OneToMany(mappedBy = "locationGroup")
  private List<UserLocationGroup> usersLocationGroups;
}

package edu.projektinzynierski.backend.services;

import edu.projektinzynierski.backend.exceptions.LocationGroupNotFoundException;
import edu.projektinzynierski.backend.exceptions.LocationNotFoundException;
import edu.projektinzynierski.backend.models.Location;
import edu.projektinzynierski.backend.models.LocationGroup;
import edu.projektinzynierski.backend.repositories.LocationGroupRepository;
import edu.projektinzynierski.backend.repositories.LocationRepository;
import edu.projektinzynierski.backend.services.requests.LocationRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService {
  private final LocationRepository locationRepository;
  private final LocationGroupRepository locationGroupRepository;

  public void createLocation(LocationRequest locationRequest) {
    LocationGroup locationGroup =
        locationGroupRepository
            .findByUuid(UUID.fromString(locationRequest.getLocationGroupUuid()))
            .orElseThrow(
                () -> new LocationGroupNotFoundException(locationRequest.getLocationGroupUuid()));
    Location location = new Location();
    if (locationGroup.getLocationsInGroup().stream()
        .noneMatch((v) -> v.getLocationName().equals(locationRequest.getLocationName()))) {
      location.setLocationName(locationRequest.getLocationName());
      location.setLocationGroup(locationGroup);
      locationRepository.save(location);
    }
  }

  public LocationRequest readLocation(String uuid) {
    UUID locationUUID = UUID.fromString(uuid);
    Location location =
        locationRepository
            .findByUuid(locationUUID)
            .orElseThrow(() -> new LocationNotFoundException(uuid));
    LocationRequest locationRequest =
        LocationRequest.builder()
            .uuid(location.getUuid().toString())
            .locationName(location.getLocationName())
            .locationGroupUuid(location.getLocationGroup().getUuid().toString())
            .build();
    return locationRequest;
  }

  public List<LocationRequest> readLocations() {
    Iterable<Location> locations = locationRepository.findAll();
    List<LocationRequest> locationRequests = new ArrayList<>();

    for (Location location : locations) {
      LocationRequest locationRequest =
          LocationRequest.builder()
              .uuid(location.getUuid().toString())
              .locationName(location.getLocationName())
              .locationGroupUuid(location.getLocationGroup().getUuid().toString())
              .build();

      locationRequests.add(locationRequest);
    }
    return locationRequests;
  }
}

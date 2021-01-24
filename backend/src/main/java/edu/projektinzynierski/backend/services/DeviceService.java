package edu.projektinzynierski.backend.services;

import edu.projektinzynierski.backend.exceptions.DeviceAlreadyExistsException;
import edu.projektinzynierski.backend.exceptions.DeviceNotFoundException;
import edu.projektinzynierski.backend.exceptions.LocationNotFoundException;
import edu.projektinzynierski.backend.exceptions.UserNotFoundException;
import edu.projektinzynierski.backend.models.Device;
import edu.projektinzynierski.backend.models.Location;
import edu.projektinzynierski.backend.repositories.DeviceRepository;
import edu.projektinzynierski.backend.repositories.LocationRepository;
import edu.projektinzynierski.backend.services.requests.DeviceRequest;
import edu.projektinzynierski.backend.services.requests.UserAccessRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceService {
  private final Logger logger = LoggerFactory.getLogger(DeviceService.class);
  private final DeviceRepository deviceRepository;
  private final LocationRepository locationRepository;
  private final VerifyUserService verifyUserService;

  public void createDevice(DeviceRequest deviceRequest) {

    deviceRepository
        .findByDeviceId(deviceRequest.getDeviceId())
        .ifPresent(
            (v) -> {
              throw new DeviceAlreadyExistsException(deviceRequest.getDeviceId());
            });

    UUID locationsUUID = UUID.fromString(deviceRequest.getLocationUuid());
    Location location =
        locationRepository
            .findByUuid(locationsUUID)
            .orElseThrow(() -> new LocationNotFoundException(String.valueOf(locationsUUID)));

    Device device = new Device();

    if (!deviceRequest.getDeviceId().isEmpty() && !deviceRequest.getType().isEmpty()) {
      device.setDeviceId(deviceRequest.getDeviceId());
      device.setType(deviceRequest.getType());
    }

    deviceRepository.save(device);
  }

  public DeviceRequest readDevice(String deviceId, UserAccessRequest userAccessRequest) {

    if (userAccessRequest.getUserSec() == null
        || !verifyUserService.userExists(UUID.fromString(userAccessRequest.getUserSec()))) {
      throw new UserNotFoundException(userAccessRequest.getUserSec());
    }

    Device device =
        deviceRepository
            .findByDeviceId(deviceId)
            .orElseThrow(() -> new DeviceNotFoundException(deviceId));

    Location location = device.getLocation();
    return DeviceRequest.builder()
        .locationUuid(device.getUuid().toString())
        .deviceId(device.getDeviceId())
        .type(device.getType())
        .locationUuid(location.getUuid().toString())
        .build();
  }

  public List<DeviceRequest> readDevices(UserAccessRequest userAccessRequest) {

    if (userAccessRequest.getUserSec() == null
        || !verifyUserService.userExists(UUID.fromString(userAccessRequest.getUserSec()))) {
      throw new UserNotFoundException(userAccessRequest.getUserSec());
    }

    Iterable<Device> devices = deviceRepository.findAll();
    List<DeviceRequest> deviceRequests = new ArrayList<>();
    for (Device device : devices) {
      DeviceRequest deviceRequest =
          DeviceRequest.builder().deviceId(device.getDeviceId()).type(device.getType()).build();
      if (device.getLocation() != null && device.getLocation().getUuid() != null) {
        deviceRequest.setLocationUuid(device.getLocation().getUuid().toString());
      }

      if (device.getUuid() != null) deviceRequest.setUuid(device.getUuid().toString());

      logger.info(deviceRequest.toString());
      deviceRequests.add(deviceRequest);
    }

    return deviceRequests;
  }

  public void updateDevice(String deviceId, DeviceRequest deviceRequest) {

    if (!verifyUserService.userExists(UUID.fromString(deviceRequest.getUserSec()))) {
      throw new UserNotFoundException(deviceRequest.getUserSec());
    }

    Device device =
        deviceRepository
            .findByDeviceId(deviceId)
            .orElseThrow(() -> new DeviceNotFoundException(deviceRequest.getDeviceId()));

    Location location;
    boolean objectHasChanged = false;

    if (!device.getDeviceId().equals(deviceRequest.getDeviceId())
        && !deviceRequest.getDeviceId().isEmpty()
        && deviceRequest.getDeviceId() != null) {
      device.setDeviceId(deviceRequest.getDeviceId());
      objectHasChanged = true;
    }

    if (!device.getDeviceId().equals(deviceRequest.getType())
        && !deviceRequest.getType().isEmpty()
        && deviceRequest.getType() != null) {
      device.setType(deviceRequest.getType());
      objectHasChanged = true;
    }

    if (!deviceRequest.getLocationUuid().isEmpty() && deviceRequest.getLocationUuid() != null) {
      location =
          locationRepository
              .findByUuid(UUID.fromString(deviceRequest.getLocationUuid()))
              .orElseThrow(() -> new LocationNotFoundException(deviceRequest.getLocationUuid()));
      if (!device.getLocation().equals(location)) {
        device.setLocation(location);
        objectHasChanged = true;
      }
    }

    if (objectHasChanged) {
      deviceRepository.save(device);
    }
  }

  public void deleteDevice(String deviceId, UserAccessRequest userAccessRequest) {

    if (!verifyUserService.userExists(UUID.fromString(userAccessRequest.getUserSec()))) {
      throw new UserNotFoundException(userAccessRequest.getUserSec());
    }

    Device device =
        deviceRepository
            .findByDeviceId(deviceId)
            .orElseThrow(() -> new DeviceNotFoundException(deviceId));
    deviceRepository.delete(device);
  }
}

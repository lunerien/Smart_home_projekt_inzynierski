package edu.projektinzynierski.backend.services;

import edu.projektinzynierski.backend.exceptions.TempHistoryNotFoundException;
import edu.projektinzynierski.backend.exceptions.UserNotFoundException;
import edu.projektinzynierski.backend.models.Device;
import edu.projektinzynierski.backend.models.TempHistory;
import edu.projektinzynierski.backend.repositories.DeviceRepository;
import edu.projektinzynierski.backend.repositories.TempHistoryRepository;
import edu.projektinzynierski.backend.services.requests.TempHistoryRequest;
import edu.projektinzynierski.backend.services.requests.UserAccessRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TempHistoryService {
  private final TempHistoryRepository tempHistoryRepository;
  private final DeviceRepository deviceRepository;
  private final VerifyUserService verifyUserService;

  public void createTempHistory(TempHistoryRequest tempHistoryRequest) {
    String deviceId = tempHistoryRequest.getDeviceUuid();
    Device device = deviceRepository.findByDeviceId(deviceId).orElse(null);
    if (device == null) {
      device = new Device();
      device.setType("Thermometer");
      device.setDeviceId(tempHistoryRequest.getDeviceUuid());
      deviceRepository.save(device);
    }
    TempHistory tempHistory = new TempHistory();
    tempHistory.setTemp(tempHistoryRequest.getTemp());
    tempHistory.setDevice(device);
    tempHistoryRepository.save(tempHistory);
  }

  public TempHistoryRequest readTempHistory(String uuid, UserAccessRequest userAccessRequest) {
    if (userAccessRequest.getUserSec() == null
        || !verifyUserService.userExists(UUID.fromString(userAccessRequest.getUserSec()))) {
      throw new UserNotFoundException(userAccessRequest.getUserSec());
    }
    TempHistory tempHistory =
        tempHistoryRepository
            .findByUuid(UUID.fromString(uuid))
            .orElseThrow(() -> new TempHistoryNotFoundException(uuid));
    return TempHistoryRequest.builder()
        .temp(tempHistory.getTemp())
        .uuid(tempHistory.getUuid().toString())
        .deviceUuid(tempHistory.getDevice().getUuid().toString())
        .build();
  }

  public List<TempHistoryRequest> readTempHistories(UserAccessRequest userAccessRequest) {
   if (userAccessRequest.getUserSec() == null
       || !verifyUserService.userExists(UUID.fromString(userAccessRequest.getUserSec()))) {
    throw new UserNotFoundException(userAccessRequest.getUserSec());
  }
    Iterable<TempHistory> tempHistories = tempHistoryRepository.findAll();

    return getTempHistoryRequests(tempHistories);
  }

  public List<TempHistoryRequest> readAllTempHistoryForDevice(String deviceUuid, UserAccessRequest userAccessRequest) {
   if (userAccessRequest.getUserSec() == null
       || !verifyUserService.userExists(UUID.fromString(userAccessRequest.getUserSec()))) {
    throw new UserNotFoundException(userAccessRequest.getUserSec());
  }
    Iterable<TempHistory> tempHistories =
        tempHistoryRepository.findAllByDevice_Uuid(UUID.fromString(deviceUuid));

    return getTempHistoryRequests(tempHistories);
  }

  private List<TempHistoryRequest> getTempHistoryRequests(Iterable<TempHistory> tempHistories) {
    List<TempHistoryRequest> tempHistoryRequests = new ArrayList<>();
    for (TempHistory tempHistory : tempHistories) {
      TempHistoryRequest tempHistoryRequest =
          TempHistoryRequest.builder()
              .temp(tempHistory.getTemp())
              .uuid(tempHistory.getUuid().toString())
              .deviceUuid(tempHistory.getDevice().getUuid().toString())
              .build();
      tempHistoryRequests.add(tempHistoryRequest);
    }
    return tempHistoryRequests;
  }
}

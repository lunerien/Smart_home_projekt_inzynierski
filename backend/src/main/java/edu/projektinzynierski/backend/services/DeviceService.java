package edu.projektinzynierski.backend.services;

import edu.projektinzynierski.backend.models.Device;
import edu.projektinzynierski.backend.models.Location;
import edu.projektinzynierski.backend.repositories.DeviceRepository;
import edu.projektinzynierski.backend.repositories.LocationRepository;
import edu.projektinzynierski.backend.services.requests.DeviceRequest;
import java.util.UUID;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class DeviceService {
  private DeviceRepository deviceRepository;
  private LocationRepository locationRepository;

  public void createDevice(DeviceRequest deviceRequest) throws Exception {
    UUID locationsUUID = UUID.fromString(deviceRequest.getUuid());
    Location location = locationRepository.findByUuid(locationsUUID).orElseThrow(()->new Exception(
        String.valueOf(locationsUUID)));
    Device device = new Device();
  }
}

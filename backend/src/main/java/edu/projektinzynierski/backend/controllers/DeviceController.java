package edu.projektinzynierski.backend.controllers;

import edu.projektinzynierski.backend.services.DeviceService;
import edu.projektinzynierski.backend.services.requests.DeviceRequest;
import edu.projektinzynierski.backend.services.requests.UserAccessRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequiredArgsConstructor
public class DeviceController {
  private final DeviceService deviceService;

  @GetMapping("/api/device/{deviceId}")
  public DeviceRequest read(
      @PathVariable String deviceId, @RequestBody UserAccessRequest userAccessRequest) {
    return deviceService.readDevice(deviceId, userAccessRequest);
  }

  @GetMapping("/api/devices")
  public List<DeviceRequest> readAll(@RequestBody UserAccessRequest userAccessRequest) {
    return deviceService.readDevices(userAccessRequest);
  }

  @PutMapping("/api/device/{deviceId}/update")
  public void update(@PathVariable String deviceId, @RequestBody DeviceRequest request) {
    deviceService.updateDevice(deviceId, request);
  }

  @DeleteMapping("/api/device/{deviceId}/delete")
  public void delete(
      @PathVariable String deviceId, @RequestBody UserAccessRequest userAccessRequest) {
    deviceService.deleteDevice(deviceId, userAccessRequest);
  }
}

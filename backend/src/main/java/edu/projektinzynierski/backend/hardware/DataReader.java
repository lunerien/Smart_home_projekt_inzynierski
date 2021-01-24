package edu.projektinzynierski.backend.hardware;

import com.pi4j.component.temperature.TemperatureSensor;
import com.pi4j.component.temperature.impl.TmpDS18B20DeviceType;
import com.pi4j.io.w1.W1Device;
import com.pi4j.io.w1.W1Master;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataReader implements CommandLineRunner {
  Logger logger = LoggerFactory.getLogger(DataReader.class);

  private final KafkaTemplate<String, String> template;

  @Override
  public void run(String... args) throws Exception {
    W1Master master = new W1Master();
    List<W1Device> w1Devices = master.getDevices(TmpDS18B20DeviceType.FAMILY_CODE);

    for (W1Device device : w1Devices) {
      try {
        logger.info("1-Wire ID: " + device.getId() + " value: " + device.getValue());
        // returns the ID of the Sensor and the  full text of the virtual file
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    while (true) {
      for (W1Device device : w1Devices) {

        String key = device.getId().replace("\n", "");
        String value = String.valueOf(((TemperatureSensor) device).getTemperature());
        Thread.sleep(5000);
        try {
          this.template.send("tempHistory", key, value);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }
}

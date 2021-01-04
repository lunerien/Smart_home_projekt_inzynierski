package edu.projektinzynierski.backend.hardware;

import com.pi4j.component.temperature.TemperatureSensor;
import com.pi4j.component.temperature.impl.TmpDS18B20DeviceType;
import com.pi4j.io.w1.W1Device;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.pi4j.io.w1.W1Master;

@Component
public class DataReader implements CommandLineRunner {
  Logger logger = LoggerFactory.getLogger(DataReader.class);
  @Override
  public void run(String... args) throws Exception {
    /* Initialize pi4j */
//    final GpioController gpio = GpioFactory.getInstance();
//
//        /* Initialize GPIO 0 as an input pin called "MyButton" and set
//           it low using the pull-down resistor.
//        */
//    GpioPinDigitalInput myButton =
//        gpio.provisionDigitalInputPin(RaspiPin.GPIO_00,
//            "MyButton",
//            PinPullResistance.PULL_DOWN);
//
//    /* Read the state (high or low) of the pin. Remember, it should be "low" */
//    PinState pinState = myButton.getState();
//    System.out.println("GPIO 0 is set to " + pinState.getName());
    /* Close all open connections. */
    //gpio.shutdown();
    W1Master master = new W1Master();
    List<W1Device> w1Devices = master.getDevices(TmpDS18B20DeviceType.FAMILY_CODE);

    for(W1Device device: w1Devices){
      try {
        logger.info("1-Wire ID: " + device.getId() + " value: " + device.getValue());
        //returns the ID of the Sensor and the  full text of the virtual file
        } catch (IOException e) {
         e.printStackTrace();
        }
    }

    while(true) {
      for (W1Device device : w1Devices) {
        //this line is enough if you want to read the temperature
        logger.info("Device: "+device.getId().replace("\n","")+" Temperature: " + ((TemperatureSensor) device).getTemperature());
        //returns the temperature as double rounded to one decimal place after the point
        //TODO Upload data to kafka stream
        Thread.sleep(5000);

      }
    }

  }
}

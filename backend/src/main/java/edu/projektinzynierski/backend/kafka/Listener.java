package edu.projektinzynierski.backend.kafka;

import edu.projektinzynierski.backend.services.TempHistoryService;
import edu.projektinzynierski.backend.services.requests.TempHistoryRequest;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Listener {
  private final Logger logger = LoggerFactory.getLogger(Listener.class);
  private final TempHistoryService tempHistoryService;

  @KafkaListener(topics = "tempHistory")
  private void listen(ConsumerRecord<?, ?> cr) throws Exception {
    logger.info("Device: " + cr.key() + " Temp: " + cr.value());
    TempHistoryRequest tempHistoryRequest =
        TempHistoryRequest.builder()
            .temp(Double.parseDouble(cr.value().toString()))
            .deviceUuid(cr.key().toString())
            .build();
    tempHistoryService.createTempHistory(tempHistoryRequest);
  }
}

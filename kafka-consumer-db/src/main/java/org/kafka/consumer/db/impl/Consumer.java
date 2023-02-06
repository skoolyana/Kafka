package org.kafka.consumer.db.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

  private static final Logger LOG = LoggerFactory.getLogger(Consumer.class);



  @KafkaListener(topics = "${kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}")
  public void consume(String eventMessage) {
    LOG.info("Received event [{}]",eventMessage);
   
  }


}


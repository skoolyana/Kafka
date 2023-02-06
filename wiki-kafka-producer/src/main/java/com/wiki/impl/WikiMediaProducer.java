package com.wiki.impl;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service

public class WikiMediaProducer {

  private static final Logger LOG = LoggerFactory.getLogger(WikiMediaProducer.class);

  @Value("${kafka.producer.topic}")
  private String topic;
  
  @Value("${wikimedia.url}")
  private String url;

  private KafkaTemplate<String, String> kafkaTemplate;
  
  public WikiMediaProducer(KafkaTemplate<String, String> kafkaTemplate) {
      this.kafkaTemplate = kafkaTemplate;
  }

  public void send() throws InterruptedException {
   
	  EventHandler eventHandler = new WikiMediaChangesHandler(kafkaTemplate,topic);
	  EventSource.Builder builder = new EventSource.Builder(eventHandler,URI.create(url));
	  EventSource eventSource = builder.build();
	  
	  eventSource.start();
	  
	  TimeUnit.MINUTES.sleep(10);  	  
  }

}

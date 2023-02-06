package org.kafka.consumer.db.impl;

import org.kafka.consumer.db.entity.WikiMediaData;
import org.kafka.consumer.db.repository.WikiMediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

  private static final Logger LOG = LoggerFactory.getLogger(Consumer.class);


  private WikiMediaDataRepository dataRepository;
  
  





public Consumer(WikiMediaDataRepository dataRepository) {
	super();
	this.dataRepository = dataRepository;
}





@KafkaListener(topics = "${kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}")
  public void consume(String eventMessage) {
    LOG.info("Received event [{}]",eventMessage);

    
    WikiMediaData wiki_data = new WikiMediaData();
    
    wiki_data.setWikiEventData(eventMessage);
    
    dataRepository.save(wiki_data);
    
    
    
  }


}


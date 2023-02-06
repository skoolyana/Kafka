package com.wiki;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wiki.impl.WikiMediaProducer;


@SpringBootApplication
class KafkaProducerApplication implements CommandLineRunner {

	@Autowired
	private WikiMediaProducer producer;
	
  public static void main(String[] args) {
    SpringApplication.run(KafkaProducerApplication.class, args);
  }

@Override
public void run(String... args) throws Exception {
	// TODO Auto-generated method stub
	
	// TODO Auto-generated method stub	
		producer.send();
}
  

}
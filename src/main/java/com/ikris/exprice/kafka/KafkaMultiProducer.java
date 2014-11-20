package com.ikris.exprice.kafka;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.ProducerConfig;

public class KafkaMultiProducer {
	
	public void init(){
		ProducerConfig config = new ProducerConfig(new Properties());
		Producer p = new Producer(config);
	}
	

}

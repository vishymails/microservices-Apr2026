package com.bvr;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StorageDemo {

	private static final Logger logger = LoggerFactory.getLogger(KafkaServiceApplication.class);
	
	public static void main(String[] args) {
		logger.info("Creating Kafka producer");
		Properties props = new Properties();
		
		props.put(ProducerConfig.CLIENT_ID_CONFIG, AppConfigs1.applicationID);
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfigs1.bootstrapServers);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		KafkaProducer<Integer, String> producer = new KafkaProducer<>(props);
		
		logger.info("Start Sending messages");
		
		for (int i = 1; i <= AppConfigs1.numEvents; i++) {
			producer.send(new ProducerRecord<>(AppConfigs1.topicName, i , "Simple Message" + i));
		}
		
		logger.info("Finished - closing Kafka Producer");
		producer.close();
		
		
	}
}

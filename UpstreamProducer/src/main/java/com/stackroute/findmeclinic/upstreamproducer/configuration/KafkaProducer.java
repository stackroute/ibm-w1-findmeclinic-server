package com.stackroute.findmeclinic.upstreamproducer.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.stackroute.findmeclinic.upstreamproducer.model.Prescription;


@Configuration
public class KafkaProducer {

	
	@Bean
	public ProducerFactory<String,Prescription> producerFactory() {
		System.out.println("insdie kafka configuration-1");
		Map<String, Object> config = new HashMap<>();
		
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, " 172.23.239.69:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory<>(config);
	}
	
	@Bean
	public KafkaTemplate<String,Prescription> kafkaTemplate(){
		System.out.println("insdie kafka configuration-2");

		return new KafkaTemplate<>(producerFactory());
		
	}
}

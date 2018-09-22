package com.stackroute.findmeclinic.doctorservices.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.stackroute.findmeclinic.doctorservices.model.Doctor;
@Configuration
public class DoctorKafkaConfigureProducer {

	   @Bean
	    public ProducerFactory<String,List<Doctor>> producerFactory() {
	        System.out.println("insdie kafka configuration-1");
	        Map<String, Object> config = new HashMap<>();
	        
	        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.23.239.228:9092");
	        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
	        
	        return new DefaultKafkaProducerFactory<>(config);
	    }
	    
	    @Bean
	    public KafkaTemplate<String,List<Doctor>> kafkaTemplate(){
	       // System.out.println("insdie kafka configuration-2");

	        return new KafkaTemplate<>(producerFactory());
	        
	    }
	
}

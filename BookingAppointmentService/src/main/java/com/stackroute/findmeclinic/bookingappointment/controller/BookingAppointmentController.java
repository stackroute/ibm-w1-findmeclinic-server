package com.stackroute.findmeclinic.bookingappointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class BookingAppointmentController {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	private static final String TOPIC = "Calender_Topic";

	@GetMapping("/publish/{message}")
	public String post(@PathVariable("message") final String message) {
		
		kafkaTemplate.send(TOPIC, message);
		
		return "Publish successfully";
		
	}
}

//~/kafka/bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic Calender_Topic
//~/kafka/bin/kafka-console-producer.sh --broker-list localhost:9092 --topic Calender_Topic > /dev/null
//~/kafka/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic Calender_Topic --from-beginning

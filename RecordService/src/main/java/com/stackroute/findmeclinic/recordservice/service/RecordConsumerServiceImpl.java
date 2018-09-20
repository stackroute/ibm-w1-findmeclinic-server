package com.stackroute.findmeclinic.recordservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

import com.stackroute.findmeclinic.recordservice.model.Prescription;
import com.stackroute.findmeclinic.recordservice.repository.RecordRepository;

public class RecordConsumerServiceImpl implements RecordConsumerService{
	
	RecordRepository repository;
	
	
	@Autowired
	public RecordConsumerServiceImpl(RecordRepository repository) {
		this.repository = repository;
	}



	@KafkaListener(topics="prescription2")
	public void consumeData(@Payload Prescription prescription) {
		System.out.println("Prescription object"+ prescription);
		/*repository.save(prescription);*/
	}

}

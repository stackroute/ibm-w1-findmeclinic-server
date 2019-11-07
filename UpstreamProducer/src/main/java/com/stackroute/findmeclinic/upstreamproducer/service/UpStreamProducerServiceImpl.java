package com.stackroute.findmeclinic.upstreamproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.stackroute.findmeclinic.upstreamproducer.model.Prescription;

@Service
public class UpStreamProducerServiceImpl implements UpStreamProducerService {

	private KafkaTemplate<String, Prescription> kafkaTemplate;

	@Autowired
	public UpStreamProducerServiceImpl(KafkaTemplate<String, Prescription> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}


	@Override
	public void sendPrescription(Prescription prescription) {
		System.out.println("inside service");
		boolean status = false;
		kafkaTemplate.send("prescription", prescription) ;
			status=true;
		}
	
	}

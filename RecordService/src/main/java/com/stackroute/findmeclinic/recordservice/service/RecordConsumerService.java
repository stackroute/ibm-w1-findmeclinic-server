package com.stackroute.findmeclinic.recordservice.service;

import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.stackroute.findmeclinic.recordservice.model.Prescription;

@Service
public interface RecordConsumerService {

	public void consumeData(@Payload Prescription prescription);
}

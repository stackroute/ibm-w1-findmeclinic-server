package com.stackroute.findmeclinic.recordservice.service;

import java.util.List;

import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.stackroute.findmeclinic.recordservice.exception.PrescriptionNotAddedException;
import com.stackroute.findmeclinic.recordservice.model.Patient;
import com.stackroute.findmeclinic.recordservice.model.Prescription;

public interface RecordConsumerService {

	public void consumeData(@Payload Prescription prescription);
	
	public List<Prescription> getPatientPrescription(String patientEmail) throws PrescriptionNotAddedException;
}

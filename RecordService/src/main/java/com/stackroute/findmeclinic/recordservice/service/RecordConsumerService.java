package com.stackroute.findmeclinic.recordservice.service;

import java.util.List;

import com.stackroute.findmeclinic.recordservice.exception.PrescriptionNotAddedException;
import com.stackroute.findmeclinic.upstreamproducer.model.Prescription;

public interface RecordConsumerService {

//	public void consumeData(@Payload Prescription prescription);
	
	public List<Prescription> getPatientPrescription(String patientEmail) throws PrescriptionNotAddedException;
}

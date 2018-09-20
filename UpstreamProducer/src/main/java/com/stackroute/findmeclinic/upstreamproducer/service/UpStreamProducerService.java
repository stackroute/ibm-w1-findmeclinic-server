package com.stackroute.findmeclinic.upstreamproducer.service;

import com.stackroute.findmeclinic.upstreamproducer.model.Prescription;

public interface UpStreamProducerService {
	
	public void sendPrescription(Prescription prescription);

}

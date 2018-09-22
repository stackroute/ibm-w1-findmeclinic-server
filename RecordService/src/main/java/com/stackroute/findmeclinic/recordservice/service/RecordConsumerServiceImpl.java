package com.stackroute.findmeclinic.recordservice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.stackroute.findmeclinic.recordservice.exception.PrescriptionNotAddedException;
import com.stackroute.findmeclinic.recordservice.repository.RecordRepository;
import com.stackroute.findmeclinic.upstreamproducer.model.Patient;
import com.stackroute.findmeclinic.upstreamproducer.model.Prescription;

@Service
public class RecordConsumerServiceImpl implements RecordConsumerService {

	RecordRepository repository;

	@Autowired
	public RecordConsumerServiceImpl(RecordRepository repository) {
		this.repository = repository;
	}

	@KafkaListener(topics = "prescription")
	public void consumeData(@Payload Prescription prescription) {
		System.out.println("Prescription object" + prescription);
		repository.save(prescription);
	}

	@Override
	public List<Prescription> getPatientPrescription(String patientEmail) throws PrescriptionNotAddedException {
		String Id = patientEmail;
		List<Prescription> requiredPrescription = new ArrayList<>();
		List<Prescription> prescription = repository.findAll();
		Iterator<Prescription> iterator = prescription.iterator();
		while (iterator.hasNext()) {
			Prescription myPrescription = iterator.next();
			Patient requiredPatient = myPrescription.getPatient();
			if (requiredPatient.getPatientEmail().equals(Id)) {
				requiredPrescription.add(myPrescription);

			} else {
				throw new PrescriptionNotAddedException("Not prescriptions available yet");
			}
		}
		return requiredPrescription;
	}

}

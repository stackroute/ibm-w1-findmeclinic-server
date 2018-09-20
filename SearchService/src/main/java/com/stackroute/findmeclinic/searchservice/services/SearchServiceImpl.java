package com.stackroute.findmeclinic.searchservice.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.findmeclinic.searchservice.model.Doctor;
import com.stackroute.findmeclinic.searchservice.model.SearchDoctor;
import com.stackroute.findmeclinic.searchservice.repository.SearchRepository;

@Service
public class SearchServiceImpl implements SearchService {
	private SimpMessagingTemplate template;
	private SearchRepository searchRepository;

	@Autowired
	public SearchServiceImpl(SimpMessagingTemplate template, SearchRepository searchRepository) {
		this.template = template;
		this.searchRepository = searchRepository;
	}

	@KafkaListener(topics = "DoctorService")
	public void consumeData(@Payload List<Doctor> doctors) throws IOException {

		System.out.println("doctor array is::" + doctors);
		ObjectMapper mapper = new ObjectMapper();

		List<Doctor> map = mapper.convertValue(doctors, List.class);
		System.out.println(map.get(0));
		Iterator itr = map.iterator();
		while (itr.hasNext()) {
			Doctor doc = mapper.convertValue(itr.next(), Doctor.class);
			System.out.println(doc.getDoctorFirstName());
			searchRepository.save(doc);

		}

	}

	@Override
	public List<Doctor> getDoctorByName(String name) {

		System.out.println("inside the method");
		List<Doctor> doctors = new ArrayList<>();

		List<Doctor> doc = (List<Doctor>) searchRepository.findAll();
		System.out.println(doc);
		Iterator itr = doc.iterator();
		while (itr.hasNext()) {
			Doctor doctor = (Doctor) itr.next();
			if (doctor.getDoctorFirstName().equals(name)) {
				doctors.add(doctor);
			}
		}

		System.out.println(doctors);

		 template.convertAndSend("/topic/getList", doctors);

		return doctors;
	}

}

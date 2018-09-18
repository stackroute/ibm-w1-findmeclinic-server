package com.stackroute.findmeclinic.bookingappointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.stackroute.findmeclinic.bookingappointment.model.BookingAppointment;
import com.stackroute.findmeclinic.bookingappointment.model.Calender;
import com.stackroute.findmeclinic.bookingappointment.model.Doctor;
import com.stackroute.findmeclinic.bookingappointment.model.DoctorCalender;
import com.stackroute.findmeclinic.bookingappointment.service.BookingAppointmentService;

@RestController
@RequestMapping("api/v1/appointment")
public class BookingAppointmentController {

	@Autowired
	private KafkaTemplate<String, DoctorCalender> kafkaTemplate;
	private static final String TOPIC = "Calender_Topic";

	@PostMapping("/publish")
	public String post(@RequestBody DoctorCalender doctorCalender) {

		kafkaTemplate.send(TOPIC, doctorCalender);
		
		return "Publish successfully";

	}

	private BookingAppointmentService bookingService;

	public BookingAppointmentController(BookingAppointmentService bookingService) {
		super();
		this.bookingService = bookingService;
	}

	@PostMapping
	public ResponseEntity<?> createBooking(@RequestBody BookingAppointment bookappointment) {
		ResponseEntity<?> responseEntity = null;

		return responseEntity;

	}

	@GetMapping("/appointments")
	public ResponseEntity<?> getAllAppointments() {
		ResponseEntity<?> responseEntity = null;
		return responseEntity;
	}

}

//~/kafka/bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic Calender_Topic
//~/kafka/bin/kafka-console-producer.sh --broker-list localhost:9092 --topic Calender_Topic > /dev/null
//~/kafka/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic Calender_Topic --from-beginning

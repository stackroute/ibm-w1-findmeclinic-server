package com.stackroute.findmeclinic.bookingappointment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.stackroute.findmeclinic.bookingappointment.model.Appointment;
import com.stackroute.findmeclinic.bookingappointment.model.BookingAppointment;
import com.stackroute.findmeclinic.bookingappointment.model.DoctorAppointment;
import com.stackroute.findmeclinic.bookingappointment.model.Schedule;
import com.stackroute.findmeclinic.bookingappointment.repository.BookingAppointmentRepository;
import com.stackroute.findmeclinic.bookingappointment.repository.DoctorAppointmentRepository;


@Service
public class BookingAppointmentServiceImpl implements BookingAppointmentService {
	
	private KafkaTemplate<String, Appointment> kafkaTemplate;
	private BookingAppointmentRepository bookingRepository;
	private DoctorAppointmentRepository doctorRepository;
	
	@Autowired
	public BookingAppointmentServiceImpl(BookingAppointmentRepository bookingRepository,DoctorAppointmentRepository doctorRepository, KafkaTemplate<String, Appointment> kafkaTemplate) {
		this.bookingRepository = bookingRepository;
		this.doctorRepository=doctorRepository;
		this.kafkaTemplate=kafkaTemplate;
	}
	
	
	@Override
	public void post(Appointment appointment) {

		kafkaTemplate.send("notificationTopic", appointment);
	
	}
	
	@Override
	@KafkaListener(topics="calenderTopic")
	public void listen(@Payload Schedule schedule) {
		System.out.println("Schedule object:"+ schedule);
		
		
		
	}
	
	@Override
	public boolean createBookingAppointment(Appointment appointment) {
		boolean flag=false;
		
		if(bookingRepository.insert(appointment)!=null)
			flag=true;
		return flag;
		
	}

	@Override
	public List<Appointment> getAllAppointmentByDoctorId(String doctorEmail) {
		List<Appointment> list=null;
		System.out.println("hi");
		if(doctorRepository.existsById(doctorEmail))
		{
			DoctorAppointment doctorAppointment  = doctorRepository.findById(doctorEmail).get();
			System.out.println(doctorAppointment.getDoctorEmail());
			System.out.println(doctorAppointment.getAppointments());


			
		 list = doctorAppointment.getAppointments();
		}
			
			return list;
	}


}

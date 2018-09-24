package com.stackroute.findmeclinic.bookingappointment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.stackroute.findmeclinic.bookingappointment.model.Appointment;
import com.stackroute.findmeclinic.bookingappointment.model.BookingAppointment;
import com.stackroute.findmeclinic.bookingappointment.model.DoctorAppointment;
import com.stackroute.findmeclinic.bookingappointment.model.Notification;
import com.stackroute.findmeclinic.bookingappointment.model.PatientAppointment;
import com.stackroute.findmeclinic.bookingappointment.model.Schedule;

import com.stackroute.findmeclinic.bookingappointment.repository.DoctorAppointmentRepository;
import com.stackroute.findmeclinic.bookingappointment.repository.PatientAppointmentRepository;


@Service
public class BookingAppointmentServiceImpl implements BookingAppointmentService {
	
	private KafkaTemplate<String, Appointment> kafkaTemplate;
	private DoctorAppointmentRepository doctorRepository;
	private PatientAppointmentRepository patientRepository;
	private RestTemplate restTemplate;
	
	@Autowired
	public BookingAppointmentServiceImpl(DoctorAppointmentRepository doctorRepository, PatientAppointmentRepository patientRepository,KafkaTemplate<String, Appointment> kafkaTemplate,RestTemplate restTemplate) {

		this.doctorRepository=doctorRepository;
		this.patientRepository=patientRepository;
		this.kafkaTemplate=kafkaTemplate;
		this.restTemplate =restTemplate;
	}
	
	
//	@Override
//	public void post(Appointment appointment) {
//
//		kafkaTemplate.send("notificationTopic", appointment);
//	
//	}
//	
//	@Override
//	@KafkaListener(topics="calenderTopic")
//	public void listen(@Payload Schedule schedule) {
//		System.out.println("Schedule object:"+ schedule);
//		
//		
//		
//	}

	
	DoctorAppointment doctorAppointment;

	List<Appointment> list;
	
	PatientAppointment patientAppointment;
	
	List<Appointment> list1;
	
	
  
	@Override
	public boolean createBookingAppointment(Appointment appointment) {

		boolean flag = false;
		int count = 1;

		if (doctorRepository.existsById(appointment.getBookedFor())) {

			list = doctorRepository.findById(appointment.getBookedFor()).get().getAppointments();

			ListIterator<Appointment> iterator = list.listIterator();

			Appointment appointment1=new Appointment();
			
			while (iterator.hasNext()) {
				appointment1=iterator.next();
			}

			appointment.setAppointmentId(appointment1.getAppointmentId() + 1);

			doctorAppointment=new DoctorAppointment();
			list.add(appointment);
			doctorAppointment.setDoctorEmail(appointment.getBookedFor());

			doctorAppointment.setAppointments(list);

			doctorAppointment = doctorRepository.save(doctorAppointment);

		}

		else {

			list = new ArrayList<Appointment>();

			doctorAppointment = new DoctorAppointment();

			doctorAppointment.setDoctorEmail(appointment.getBookedFor());
			
			appointment.setAppointmentId(count);

			list.add(appointment);

			doctorAppointment.setAppointments(list);

			doctorAppointment = doctorRepository.insert(doctorAppointment);

		}

		if (patientRepository.existsById(appointment.getBookingBy())) {

			list1 = patientRepository.findById(appointment.getBookingBy()).get().getAppointments();

			ListIterator<Appointment> iterator = list1.listIterator();

			Appointment appointment1=new Appointment();
			
			while (iterator.hasNext()) {
				appointment1=iterator.next();
			}

			appointment.setAppointmentId(appointment1.getAppointmentId() + 1);

			patientAppointment=new PatientAppointment();
			list1.add(appointment);
			patientAppointment.setPatientEmail(appointment.getBookingBy());

			patientAppointment.setAppointments(list1);

			patientAppointment = patientRepository.save(patientAppointment);

		}

		else {

			list1 = new ArrayList<Appointment>();

			patientAppointment = new PatientAppointment();

			patientAppointment.setPatientEmail(appointment.getBookingBy());
			
			appointment.setAppointmentId(count);

			list1.add(appointment);

			patientAppointment.setAppointments(list);

			patientAppointment = patientRepository.insert(patientAppointment);

		}
		
		
		if (doctorAppointment != null && patientAppointment != null) {
		
		flag = true;
		
		

		Notification notification =new Notification();
		
		notification.setDoctor(appointment.getBookedFor());
		notification.setPatient(appointment.getBookingBy());

        restTemplate.postForObject("http://172.23.239.225:8009/api/v1/notify/", notification , Notification.class);
		
		}
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

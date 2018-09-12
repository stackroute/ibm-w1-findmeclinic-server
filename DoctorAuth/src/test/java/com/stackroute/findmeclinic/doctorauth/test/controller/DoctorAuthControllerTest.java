package com.stackroute.findmeclinic.doctorauth.test.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.ArgumentMatchers.any;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.findmeclinic.doctorauth.controller.DoctorAuthController;
import com.stackroute.findmeclinic.doctorauth.exception.DoctorAlreadyExistsEcxeption;
import com.stackroute.findmeclinic.doctorauth.model.Doctor;
import com.stackroute.findmeclinic.doctorauth.service.DoctorAuthService;


@RunWith(SpringRunner.class)
@WebMvcTest
public class DoctorAuthControllerTest {
	
	
	 @Autowired
	    private MockMvc mockMvc;
	    @MockBean
	    private Doctor doctor;
	    @MockBean
	    DoctorAuthService doctorAuthService;
	    @InjectMocks
	    DoctorAuthController doctorAuthController;

	    
	    @Before
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders.standaloneSetup(doctorAuthController).build();
	        doctor = new Doctor();
	       // doctor1= new Doctor();
	      doctor.setDoctorEmail("sanela97@gmail.com");
	      doctor.setDoctorPhoneNumber("9994224303");
	      doctor.setDoctorPassword("sanjana");
	    /*  doctor1.setDoctorEmail("sanela97@gmail.com");
	      doctor1.setDoctorPhoneNumber("9994224303");
	      doctor1.setDoctorPassword("sanjana");*/
	    }
	    
	    
	    @Test
	    public void registerDoctorSuccess() throws Exception {

	        when(doctorAuthService.registerDoctor(doctor)).thenReturn(doctor);
	        mockMvc.perform(post("/doctor/auth")
	                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(doctor)))
	                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());

	    }
	    
	    @Test
	    public void registerDoctorFailure() throws Exception {

	        when(doctorAuthService.registerDoctor(any())).thenThrow(DoctorAlreadyExistsEcxeption.class);
	        mockMvc.perform(post("/doctor/auth")
	                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(doctor)))
	                .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());
}
	    
	    public static String asJsonString(final Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	    
		@Test
	    public void loginDoctorSuccess() throws Exception{
			when(doctorAuthService.findDoctorByDoctorEmailAndDoctorPassword(doctor.getDoctorEmail(), doctor.getDoctorPassword())).thenReturn(doctor);
			mockMvc.perform(post("/doctor/auth")
					.contentType(MediaType.APPLICATION_JSON).content(asJsonString(doctor))).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
		
	    }
		
		@Test
		public void loginDoctorFailure() throws Exception{
			when(doctorAuthService.findDoctorByDoctorEmailAndDoctorPassword(doctor.getDoctorEmail(), doctor.getDoctorPassword())).thenReturn(null);
			mockMvc.perform(post("/api/v1/patient/login")
					.contentType(MediaType.APPLICATION_JSON).content(asJsonString(doctor))).andExpect(status().isUnauthorized()).andDo(MockMvcResultHandlers.print());
		
			
		}
	    
}

package com.stackroute.findmeclinic.patientauth.test.controller;

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
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.stackroute.findmeclinic.patientauth.controller.PatientAuthController;
import com.stackroute.findmeclinic.patientauth.exception.PatientAlreadyExistsException;
import com.stackroute.findmeclinic.patientauth.model.Patient;
import com.stackroute.findmeclinic.patientauth.service.PatientService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PatientAuthControllerTest {
	 @Autowired
	    private MockMvc mockMvc;
	    @MockBean
	    private Patient patient;
	    @MockBean
	    private PatientService patientService;
	    @InjectMocks
	   PatientAuthController patientAuthController;
	    

	    @Before
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders.standaloneSetup(patientAuthController).build();
	         patient = new Patient();
	        patient.setPatientEmail("abcde89@gmail.com");
	        patient.setPatientPhoneNumber("1234567");
	        patient.setPatientPassword("password");
	        
	        
	    }
	        
	    @Test
	    public void registerPatientUserSuccess() throws Exception {
	    	
	    	when(patientService.registerPatient(patient)).thenReturn(patient); 
	    	 mockMvc.perform(post("/api/v1/patient")
	    	                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(patient)))
                            .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
	    	 
	    	
	    }

	    
	   
	    @Test
	    public void registerPatientUserFailure() throws Exception {
	    	
	    	when(patientService.registerPatient(any())).thenThrow(PatientAlreadyExistsException.class); 
	    	 mockMvc.perform(post("/api/v1/patient")
	    	           .contentType(MediaType.APPLICATION_JSON).content(asJsonString(patient)))
                       .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());
	    	 
	    	
	    }

	   

		public static String asJsonString(final Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	    
		
	    
}


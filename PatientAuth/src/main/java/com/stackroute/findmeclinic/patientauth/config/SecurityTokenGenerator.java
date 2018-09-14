package com.stackroute.findmeclinic.patientauth.config;

import java.util.Map;

import com.stackroute.findmeclinic.patientauth.model.Patient;

@FunctionalInterface
public interface SecurityTokenGenerator {

	Map<String, String> generateToken(Patient patient);
}

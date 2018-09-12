package com.stackroute.findmeclinic.doctorauth.config;

import java.util.Map;

import com.stackroute.findmeclinic.doctorauth.model.Doctor;


@FunctionalInterface
public interface SecurityTokenGenerator {
	Map<String, String> generateToken(Doctor doctor);
}

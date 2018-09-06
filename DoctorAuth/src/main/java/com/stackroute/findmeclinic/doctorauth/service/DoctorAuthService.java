package com.stackroute.findmeclinic.doctorauth.service;

<<<<<<< HEAD:DoctorAuth/src/main/java/com/stackroute/findmeclinic/doctorauth/service/DoctorAuthService.java
import com.stackroute.findmeclinic.doctorauth.exception.DoctorAlreadyExistsEcxeption;
import com.stackroute.findmeclinic.doctorauth.model.Doctor;
=======
import javax.servlet.ServletException;

import com.stackroute.findMeClinic.doctorAuth.exception.DoctorAlreadyExistsEcxeption;
import com.stackroute.findMeClinic.doctorAuth.model.Doctor;
>>>>>>> b186585a9bb447da5645d6f465a69226253650fc:DoctorAuth/src/main/java/com/stackroute/findMeClinic/doctorAuth/service/DoctorAuthService.java

public interface DoctorAuthService {

	
	public boolean registerDoctor(Doctor doctor) throws DoctorAlreadyExistsEcxeption;
	public Doctor findDoctorBydoctorPhoneNumber(String doctorPhoneNumber);
	public String loginToken(Doctor login) throws ServletException;
	
}

package com.stackroute.findmeclinic.doctorauth.service;

import java.util.Date;
import java.util.NoSuchElementException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.findmeclinic.doctorauth.exception.DoctorAlreadyExistsEcxeption;
import com.stackroute.findmeclinic.doctorauth.model.Doctor;
import com.stackroute.findmeclinic.doctorauth.repository.DoctorAuthRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class DoctorAuthServiceImpl implements DoctorAuthService {

	private DoctorAuthRepository doctorAuth;
	
	@Autowired
	public DoctorAuthServiceImpl(DoctorAuthRepository doctorAuth) {
		this.doctorAuth = doctorAuth;
		
	}

	@Override
    public boolean registerDoctor(Doctor doctor) throws DoctorAlreadyExistsEcxeption {
        boolean flag = false;
        String info = doctor.getDoctorEmail();

        try {
            if (!doctorAuth.existsById(info) && (findDoctorBydoctorPhoneNumber(doctor.getDoctorPhoneNumber()) == null)) {
                doctorAuth.save(doctor);
                flag = true;
            } else {
                throw new DoctorAlreadyExistsEcxeption("Doctor Information already present");
            }
            if (flag == true) {
                return flag;
            } else {
                return false;
            }
        } catch (NoSuchElementException exception) {
            throw new DoctorAlreadyExistsEcxeption("Doctor Information already present");
        }
    }

	public Doctor findDoctorBydoctorPhoneNumber(String doctorPhoneNumber) {
		Doctor info = doctorAuth.findDoctorBydoctorPhoneNumber(doctorPhoneNumber);
		if (info != null) {
			return info;
		} else {
			return null;
		}
	}
	
public String loginToken(Doctor login) throws ServletException {
		
		String pwd1=null;
	    String pwd2=null;
	    String jwtToken = "";

//	    if ((login.getDoctorEmail() == null && login.getDoctorPhoneNumber() == null) || login.getDoctorPassword() == null ) {
//	        throw new ServletException("Please fill in username and password");
//	    }
        
	    String phoneNumber = login.getDoctorPhoneNumber();
	    String email = login.getDoctorEmail();
	    String password = login.getDoctorPassword();

	    Doctor doctor1 = doctorAuth.findDoctorBydoctorEmail(email);
	    Doctor doctor2 = doctorAuth.findDoctorBydoctorPhoneNumber(phoneNumber);

	    
	    if (doctor1 != null ) {
	    	 pwd1 = doctor1.getDoctorPassword();
	    }
	    else if(doctor2 !=null) {
	     pwd2 = doctor2.getDoctorPassword();
	    }
	    else {
	    	 throw new ServletException("User name not found.");
	    }
	   
	    if (password.equals(pwd1)) {
	    	jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date())
		            .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

	    }
	    else if(password.equals(pwd2)){
	    	jwtToken = Jwts.builder().setSubject(phoneNumber).claim("roles", "user").setIssuedAt(new Date())
		            .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

	    }
	    else {
	    	throw new ServletException("Invalid login. Please check your name and password.");
	    }

	    
	    return jwtToken;
	}

}

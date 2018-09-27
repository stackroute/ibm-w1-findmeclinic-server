package com.stackroute.findmeclinic.recordservice;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stackroute.findmeclinic.recordservice.storage.StorageService;

@SpringBootApplication
public class RecordServiceApplication implements CommandLineRunner {

	@Resource
	StorageService storageService;
	
	public static void main(String[] args) {
		SpringApplication.run(RecordServiceApplication.class, args);
	}
	 
		@Override
		public void run(String... arg) throws Exception {
			storageService.deleteAll();
			storageService.init();
		}
		
	}


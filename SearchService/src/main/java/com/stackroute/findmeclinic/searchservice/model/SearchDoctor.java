package com.stackroute.findmeclinic.searchservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


public class SearchDoctor {

	
	private String searchId;
	private List<Doctor> searchDoctor;

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public List<Doctor> getSearchDoctor() {
		return searchDoctor;
	}

	public void setSearchDoctor(List<Doctor> searchDoctor) {
		this.searchDoctor = searchDoctor;
	}

	@Override
	public String toString() {
		return "SearchDoctor [searchId=" + searchId + ", searchDoctor=" + searchDoctor + "]";
	}

}

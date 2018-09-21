package com.stackroute.findmeclinic.upstreamproducer.model;

public class Medicine {

	
	private String medicineName;
	private String timing;
	private String morning;
	private String afternoon;
	private String evening;
	private String night;
	public Medicine() {
		super();

	}
	public Medicine(String medicineName, String timing, String morning, String afternoon, String evening,
			String night) {
		super();
		this.medicineName = medicineName;
		this.timing = timing;
		this.morning = morning;
		this.afternoon = afternoon;
		this.evening = evening;
		this.night = night;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getTiming() {
		return timing;
	}
	public void setTiming(String timing) {
		this.timing = timing;
	}
	public String getMorning() {
		return morning;
	}
	public void setMorning(String morning) {
		this.morning = morning;
	}
	public String getAfternoon() {
		return afternoon;
	}
	public void setAfternoon(String afternoon) {
		this.afternoon = afternoon;
	}
	public String getEvening() {
		return evening;
	}
	public void setEvening(String evening) {
		this.evening = evening;
	}
	public String getNight() {
		return night;
	}
	public void setNight(String night) {
		this.night = night;
	}
	@Override
	public String toString() {
		return "Medicine [medicineName=" + medicineName + ", timing=" + timing + ", morning=" + morning + ", afternoon="
				+ afternoon + ", evening=" + evening + ", night=" + night + "]";
	}
	
	
}
	
	
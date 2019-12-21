package com.extremesolutions.rest.dto;



import java.time.LocalTime;



public class TimeScheduleDto {
    

    private Long id;
	private LocalTime from;
	private LocalTime to;
	private Long appointmentTime;
	private int day;
	private boolean automatic;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalTime getFrom() {
		return from;
	}

	public void setFrom(LocalTime from) {
		this.from = from;
	}

	public LocalTime getTo() {
		return to;
	}

	public void setTo(LocalTime to) {
		this.to = to;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	

	public Long getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(Long appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public boolean isAutomatic() {
		return automatic;
	}

	public void setAutomatic(boolean automatic) {
		this.automatic = automatic;
	}

	@Override
	public String toString() {
		return "TimeScheduleDto [id=" + id + ", from=" + from + ", to=" + to + ", appointmentTime=" + appointmentTime
				+ ", day=" + day + ", automatic=" + automatic + "]";
	}
	
	

}

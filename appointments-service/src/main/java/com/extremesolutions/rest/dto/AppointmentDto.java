package com.extremesolutions.rest.dto;



import java.time.LocalDate;
import java.time.LocalTime;



public class AppointmentDto {
    

    private Long id;
	private LocalTime from;
	private LocalTime to;
	private float appointmentTime;
	private int day;
	private LocalDate date;
	private DoctorDto doctor;
	private PatientDto patient;
	
	
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
	public float getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(float appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public DoctorDto getDoctor() {
		return doctor;
	}
	public void setDoctor(DoctorDto doctor) {
		this.doctor = doctor;
	}
	public PatientDto getPatient() {
		return patient;
	}
	public void setPatient(PatientDto patient) {
		this.patient = patient;
	}
	@Override
	public String toString() {
		return "AppointmentDto [id=" + id + ", from=" + from + ", to=" + to + ", appointmentTime=" + appointmentTime
				+ ", day=" + day + ", date=" + date + ", doctor=" + doctor + ", patient=" + patient + "]";
	}
	
}

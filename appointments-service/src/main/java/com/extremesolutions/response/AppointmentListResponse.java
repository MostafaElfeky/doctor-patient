package com.extremesolutions.response;

import java.util.List;

import com.extremesolutions.rest.dto.AppointmentDto;

public class AppointmentListResponse {

	List<AppointmentDto> appointmentDtos;

	public List<AppointmentDto> getAppointmentDtos() {
		return appointmentDtos;
	}

	public void setAppointmentDtos(List<AppointmentDto> appointmentDtos) {
		this.appointmentDtos = appointmentDtos;
	}

	@Override
	public String toString() {
		return "AppointmentResponse [appointmentDtos=" + appointmentDtos + "]";
	}
	
}

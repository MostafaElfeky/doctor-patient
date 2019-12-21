package com.extremesolutions.response;

import java.util.List;

import com.extremesolutions.rest.dto.DoctorDto;

public class DoctorListResponse {

	private List<DoctorDto> doctors;

	public List<DoctorDto> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<DoctorDto> doctors) {
		this.doctors = doctors;
	}

}

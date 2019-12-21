package com.extremesolutions.rest.response;

import java.util.List;

import com.extremesolutions.rest.dto.PatientDto;

public class PatientListResponse {

	private List<PatientDto> patientDtos;

	public List<PatientDto> getPatientDtos() {
		return patientDtos;
	}

	public void setPatientDtos(List<PatientDto> patientDtos) {
		this.patientDtos = patientDtos;
	}

	
}

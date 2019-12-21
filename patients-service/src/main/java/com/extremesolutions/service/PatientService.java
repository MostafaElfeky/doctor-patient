package com.extremesolutions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extremesolutions.models.Patient;
import com.extremesolutions.repository.PatientRepository;
import com.extremesolutions.rest.dto.PatientDto;
import com.extremesolutions.util.ObjectMapper;

@Service
public class PatientService {

	@Autowired
	PatientRepository patientRepository;
	
	
	public PatientDto register(PatientDto patientDto) {

		Patient patient = ObjectMapper.map(patientDto, Patient.class);
		patient = patientRepository.save(patient);
		
		return ObjectMapper.map(patient, PatientDto.class);
	}
	
	public List<PatientDto> list() {
				
		List<Patient> patients = patientRepository.findAll();
		List<PatientDto> patientDtos = ObjectMapper.mapAll(patients, PatientDto.class);
		
		return patientDtos;
	}
	
	public PatientDto getPatient(Long patientId) {
		
		Patient patient = patientRepository.findById(patientId).get();
		PatientDto patientDto = ObjectMapper.map(patient, PatientDto.class);
		
		return patientDto;
	}
	
}

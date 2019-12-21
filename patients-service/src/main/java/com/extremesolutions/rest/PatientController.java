package com.extremesolutions.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.extremesolutions.rest.dto.PatientDto;
import com.extremesolutions.rest.response.PatientListResponse;
import com.extremesolutions.service.PatientService;


@RestController
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	
	@PostMapping
	public PatientDto register(@RequestBody PatientDto patientDto) {
		
		return patientService.register(patientDto);
	}
	
	@GetMapping
	public PatientListResponse list() {
		
		PatientListResponse response = new PatientListResponse(); 
		
		List<PatientDto> patientDtos = patientService.list();		
		response.setPatientDtos(patientDtos);
		
		return response;
	}
	
	@GetMapping("/{patientId}")
	public PatientDto getDoctor(@PathVariable(name = "patientId") Long patientId) {
		
		PatientDto patientDto = patientService.getPatient(patientId);
		
		return patientDto;
	}
	
}

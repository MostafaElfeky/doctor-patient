package com.extremesolutions.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.extremesolutions.rest.dto.DoctorDto;
import com.extremesolutions.rest.response.DoctorListResponse;
import com.extremesolutions.service.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	
	@PostMapping
	public DoctorDto register(@RequestBody DoctorDto doctorDto) {
		
		return doctorService.register(doctorDto);
	}
	
	@GetMapping
	public DoctorListResponse list() {
		
		DoctorListResponse response = new DoctorListResponse(); 
		
		List<DoctorDto> doctorDto  = doctorService.list();		
		response.setDoctors(doctorDto);
		
		return response;
	}
	
	@GetMapping("/{doctorId}")
	public DoctorDto getDoctor(@PathVariable(name = "doctorId") Long doctorId) {
		
		DoctorDto doctorDto = doctorService.getDoctor(doctorId);		
		return doctorDto;
	}
	
	
}

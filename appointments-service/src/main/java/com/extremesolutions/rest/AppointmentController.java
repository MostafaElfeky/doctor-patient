package com.extremesolutions.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.extremesolutions.response.AppointmentListResponse;
import com.extremesolutions.rest.dto.AppointmentDto;
import com.extremesolutions.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	
	@PostMapping
	public AppointmentDto create(@RequestBody AppointmentDto appointmentDto) {
		
		return appointmentService.create(appointmentDto);
	}
	
	@GetMapping("/free")
	public AppointmentListResponse getFreeApoitment() {
		
		AppointmentListResponse response = new AppointmentListResponse();
		
		List<AppointmentDto> appointmentDtos = appointmentService.getFreeApointment();
		
		response.setAppointmentDtos(appointmentDtos);
		
		return response;
	}
	
	@PutMapping("/reserve")
	public AppointmentDto reserveApoitment(
			@RequestParam(name="appointmentId") Long appointmentId,
			@RequestParam(name="patientId") Long patientId
			) {
				
		AppointmentDto appointmentDto = appointmentService.resrve(appointmentId, patientId);
		return appointmentDto;
	}
	
}

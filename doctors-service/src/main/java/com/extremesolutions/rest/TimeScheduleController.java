package com.extremesolutions.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.extremesolutions.rest.dto.TimeScheduleDto;
import com.extremesolutions.service.TimeScheduleService;



@RestController
@RequestMapping("/time-schedules")
public class TimeScheduleController {

	@Autowired
	private TimeScheduleService timeScheduleService;
	
	
	@PostMapping
	public TimeScheduleDto create(@RequestBody TimeScheduleDto timeScheduleDto) {
				
		return timeScheduleService.create(timeScheduleDto);
	}
	
}

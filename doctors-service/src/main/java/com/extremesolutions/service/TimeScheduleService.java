package com.extremesolutions.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extremesolutions.models.TimeSchedule;
import com.extremesolutions.repository.TimeScheduleRepository;
import com.extremesolutions.rest.dto.TimeScheduleDto;
import com.extremesolutions.util.ObjectMapper;

@Service
public class TimeScheduleService {

	@Autowired
	TimeScheduleRepository timeScheduleRepository;
	

	public TimeScheduleDto create(TimeScheduleDto timeScheduleDto) {
		
		TimeSchedule timeSchedule = ObjectMapper.map(timeScheduleDto, TimeSchedule.class);
		timeSchedule = timeScheduleRepository.save(timeSchedule);
		
		return ObjectMapper.map(timeScheduleDto, TimeScheduleDto.class);
	}
	
}

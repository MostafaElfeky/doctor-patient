package com.extremesolutions.service;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.extremesolutions.models.Appointment;
import com.extremesolutions.repository.AppointmentRepository;
import com.extremesolutions.response.DoctorListResponse;
import com.extremesolutions.rest.dto.AppointmentDto;
import com.extremesolutions.rest.dto.DoctorDto;
import com.extremesolutions.rest.dto.TimeScheduleDto;
import com.extremesolutions.util.ObjectMapper;

/**
 * @author mostafa
 *
 */
@Service
public class AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public AppointmentDto create(AppointmentDto appointmentDto) {
		
		Appointment appointment = ObjectMapper.map(appointmentDto, Appointment.class);
		
		appointment = appointmentRepository.save(appointment);
		 
		return ObjectMapper.map(appointment, AppointmentDto.class);
	}
	
	public AppointmentDto resrve(Long appointmentId, Long patientId) {
		
		Appointment appointment = appointmentRepository.getOne(appointmentId);
		
		if (appointment.getPatientId() == null) {
			appointment.setPatientId(patientId);
			appointment = appointmentRepository.save(appointment);
		} else {
			throw new RuntimeException("Already reserved");
		}
		
		return ObjectMapper.map(appointment, AppointmentDto.class);
	}
	
	/**
	 * Get free appointment when no patient reserve this appointment
	 * */
	public List<AppointmentDto> getFreeApointment() {

		List<Appointment> appointments = appointmentRepository.findByPatientIdIsNull();
		List<AppointmentDto> appointmentDtos = null;
		
		if (appointments != null) {
			appointmentDtos = appointments.stream()
				.map(appointment -> {
					DoctorDto doctorDto = restTemplate.getForObject("http://doctors-service/doctors/" 
							+ appointment.getDoctorId(), DoctorDto.class);
					
					AppointmentDto appointmentDto = ObjectMapper.map(appointment, AppointmentDto.class);
					appointmentDto.setDoctor(doctorDto);
					return appointmentDto;
				})
				.collect(Collectors.toList());
		}
		
		return appointmentDtos;
	}
	
	/**
	 * Create automatic appointment for each doctor depending on doctor time schedule configuration
	 * should run every day. 
	 * */
	@Transactional
	@Scheduled(fixedRate = 86400000) // Run every day(24H)
    public void create() {
		
		System.out.println("Going to update appointment...");
		
		try {
			
			DoctorListResponse response = restTemplate.getForObject("http://doctors-service/doctors", DoctorListResponse.class);
	        List<DoctorDto> doctors = response.getDoctors();
	        
	        if(doctors != null && !doctors.isEmpty())
	        	appointmentRepository.deleteByAppointmentDate(LocalDate.now());
	        
	        for(DoctorDto doctor : doctors) {
	        	if(doctor.getTimeSchedules() != null) {
	        		for(TimeScheduleDto timeSchedule : doctor.getTimeSchedules()) {
	        			if(timeSchedule.isAutomatic())
	        				saveTimeSchedulesAppointment(timeSchedule, doctor);
	        		}
	        	}
	        }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	/**
	 * Split doctor time schedule into many appointments depending on time schedule configured period
	 * */
	private void saveTimeSchedulesAppointment(TimeScheduleDto timeSchedule, DoctorDto doctor) {
		
		while (timeSchedule.getFrom().isBefore(timeSchedule.getTo())) {

			Appointment appointment = new Appointment();
			
			appointment.setAppointmentDate(LocalDate.now());
			appointment.setAppointmentTime(timeSchedule.getAppointmentTime());
			
			appointment.setDay(timeSchedule.getDay());
			appointment.setDoctorId(doctor.getId());
			
			appointment.setFrom(timeSchedule.getFrom());
			appointment.setTo(timeSchedule.getFrom().plus(timeSchedule.getAppointmentTime(), ChronoUnit.MINUTES));
			timeSchedule.setFrom(timeSchedule.getFrom().plus(timeSchedule.getAppointmentTime(), ChronoUnit.MINUTES));

			appointmentRepository.save(appointment);
		}
		
	}
	
}

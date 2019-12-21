package com.extremesolutions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extremesolutions.models.Doctor;
import com.extremesolutions.repository.DoctorRepository;
import com.extremesolutions.rest.dto.DoctorDto;
import com.extremesolutions.util.ObjectMapper;

@Service
public class DoctorService {

	@Autowired
	DoctorRepository doctorRepository;
	
	
	public DoctorDto register(DoctorDto doctorDto) {
		
		Doctor doctor = ObjectMapper.map(doctorDto, Doctor.class);
		doctor = doctorRepository.save(doctor);
		
		return ObjectMapper.map(doctor, DoctorDto.class);
	}
	
	public List<DoctorDto> list() {
		
		List<Doctor> doctors = doctorRepository.findAll();
		List<DoctorDto> doctorDto = ObjectMapper.mapAll(doctors, DoctorDto.class);
		
		return doctorDto;
	}
	
	public DoctorDto getDoctor(Long doctorId) {
		
		Doctor doctor = doctorRepository.findDoctorById(doctorId);
		DoctorDto doctorDto = ObjectMapper.map(doctor, DoctorDto.class);
		
		return doctorDto;
	}
	
}

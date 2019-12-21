package com.extremesolutions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;

import com.extremesolutions.models.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	@EntityGraph(value = "Doctor.details", type = EntityGraphType.FETCH)
	Doctor findDoctorById(Long doctorId);
	
	@EntityGraph(value = "Doctor.details", type = EntityGraphType.FETCH)
	List<Doctor> findAll();

}

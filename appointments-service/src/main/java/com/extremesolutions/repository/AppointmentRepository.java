package com.extremesolutions.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.extremesolutions.models.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	List<Appointment> findByPatientIdIsNull();

	@Modifying
	void deleteByAppointmentDate(LocalDate now);

}

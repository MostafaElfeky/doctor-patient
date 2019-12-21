package com.extremesolutions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.extremesolutions.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {


}

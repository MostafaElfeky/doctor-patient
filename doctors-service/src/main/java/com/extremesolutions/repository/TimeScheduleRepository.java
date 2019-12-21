package com.extremesolutions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.extremesolutions.models.TimeSchedule;

public interface TimeScheduleRepository extends JpaRepository<TimeSchedule, Long> {

}

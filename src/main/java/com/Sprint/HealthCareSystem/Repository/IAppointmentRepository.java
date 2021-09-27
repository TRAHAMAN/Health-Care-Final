package com.Sprint.HealthCareSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Sprint.HealthCareSystem.Entity.Appointment;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Integer>{

	List<Appointment> findAllById(int id);

}

package com.Sprint.HealthCareSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Sprint.HealthCareSystem.Entity.Patient;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer>{
	Patient findByName(String name);

}

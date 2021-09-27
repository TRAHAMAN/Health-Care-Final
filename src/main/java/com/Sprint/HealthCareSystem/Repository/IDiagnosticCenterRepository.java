package com.Sprint.HealthCareSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Sprint.HealthCareSystem.Entity.DiagnosticCenter;


public interface IDiagnosticCenterRepository extends JpaRepository<DiagnosticCenter, Integer>{

	boolean existsByName(String centername);

	DiagnosticCenter getDiagnosticCenter(String centername);

	boolean findByName(String centername);

}

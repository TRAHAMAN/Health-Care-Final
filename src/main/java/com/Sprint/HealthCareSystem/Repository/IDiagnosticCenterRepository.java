package com.Sprint.HealthCareSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Sprint.HealthCareSystem.Entity.DiagnosticCenter;
import com.Sprint.HealthCareSystem.Entity.DiagnosticTest;


public interface IDiagnosticCenterRepository extends JpaRepository<DiagnosticCenter, Integer>{

}

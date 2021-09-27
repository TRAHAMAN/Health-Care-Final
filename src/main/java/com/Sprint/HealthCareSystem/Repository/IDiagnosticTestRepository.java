package com.Sprint.HealthCareSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Sprint.HealthCareSystem.Entity.DiagnosticTest;

@Repository
public interface IDiagnosticTestRepository extends JpaRepository<DiagnosticTest, Integer>{

}

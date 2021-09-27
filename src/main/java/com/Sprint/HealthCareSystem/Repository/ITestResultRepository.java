package com.Sprint.HealthCareSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sprint.HealthCareSystem.Entity.DiagnosticTest;
import com.Sprint.HealthCareSystem.Entity.TestResult;

@Repository
public interface ITestResultRepository extends JpaRepository<TestResult, Integer>{

	DiagnosticTest saveAndFlush(DiagnosticTest test);

}

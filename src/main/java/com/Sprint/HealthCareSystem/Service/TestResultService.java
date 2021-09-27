package com.Sprint.HealthCareSystem.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Sprint.HealthCareSystem.Entity.DiagnosticTest;
import com.Sprint.HealthCareSystem.Entity.Patient;
import com.Sprint.HealthCareSystem.Entity.TestResult;
import com.Sprint.HealthCareSystem.Exceptions.DataAlreadyExists;
import com.Sprint.HealthCareSystem.Exceptions.DataNotFound;
import com.Sprint.HealthCareSystem.Exceptions.TestResultNotFound;

@Service
public interface TestResultService {
	public TestResult addTestResult(TestResult test) throws DataAlreadyExists;
	public TestResult updateResult(TestResult test) throws DataNotFound; 
	public List<TestResult> viewResultsByPatient(Patient patient) throws DataNotFound, TestResultNotFound;
	public List<TestResult> removeTest(DiagnosticTest test) throws TestResultNotFound;
	public TestResult getById(int id) throws DataNotFound;
	public List<TestResult> getAll();

}

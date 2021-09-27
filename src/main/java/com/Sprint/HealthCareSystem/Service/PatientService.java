package com.Sprint.HealthCareSystem.Service;

import org.springframework.stereotype.Service;
import com.Sprint.HealthCareSystem.Entity.Patient;
import com.Sprint.HealthCareSystem.Entity.TestResult;
import com.Sprint.HealthCareSystem.Exceptions.DataAlreadyExists;
import com.Sprint.HealthCareSystem.Exceptions.DataNotFound;
import com.Sprint.HealthCareSystem.Exceptions.InvalidUserName;

import java.util.*;

@Service
public interface PatientService {
	public Patient registerPatient(Patient patient) throws DataAlreadyExists;
	//public Patient updatePatientDetails(Patient patient);
	public Patient updatePatientDetails(int id, Patient patient) throws DataNotFound;
	//public Patient viewPatient(String patientUserName);
	public Patient viewPatient(int id) throws DataNotFound;
	public List<TestResult> getAllTestResult(String patientUserName) throws DataNotFound, InvalidUserName;
	public TestResult viewTestResult(int testResultId) throws DataNotFound;
	public List<Patient> getAll();
}

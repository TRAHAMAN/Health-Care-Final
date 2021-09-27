package com.Sprint.HealthCareSystem.Service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Sprint.HealthCareSystem.Entity.Patient;
import com.Sprint.HealthCareSystem.Entity.TestResult;
import com.Sprint.HealthCareSystem.Exceptions.DataAlreadyExists;
import com.Sprint.HealthCareSystem.Exceptions.DataNotFound;
import com.Sprint.HealthCareSystem.Exceptions.InvalidUserName;
import com.Sprint.HealthCareSystem.Repository.IPatientRepository;
import com.Sprint.HealthCareSystem.Repository.ITestResultRepository;
//import com.Sprint.HealthCareSystem.Repository.IUserRepository;
import com.Sprint.HealthCareSystem.Repository.Queries.QueryClass;

@Service
public class IPatientService implements PatientService {
	@Autowired	
	private IPatientRepository ipatientRepository;
	@Autowired	
	private ITestResultRepository itestresultRepository;
	/*@Autowired	
	private IUserRepository iuserRepository;*/
	@Autowired(required = false)
	QueryClass qc;

	@Override
	public Patient registerPatient(Patient patient) throws DataAlreadyExists {
		if(ipatientRepository.existsById(patient.getPatientId()))
			throw new DataAlreadyExists("Patient Already Exists, Id: "+ patient.getPatientId());
		else
			ipatientRepository.save(patient);
		return patient;
	}

	@Override
	public Patient updatePatientDetails(int id, Patient patient) throws DataNotFound {
		Patient pt = null;
		Optional<Patient> optionalPatient = ipatientRepository.findById(id);
		if(optionalPatient.isPresent())
			pt = optionalPatient.get();
		else
			throw new DataNotFound("Data is not found!! Please register your name.");
		pt.setName(patient.getName());
		pt.setPhoneNo(patient.getPhoneNo());
		pt.setAge(patient.getAge());
		pt.setGender(patient.getGender());
		ipatientRepository.save(pt);
		System.out.println("Patient Details Updated Successfully !!!");
		return patient;
	}

	@Override
	public Patient viewPatient(int id) throws DataNotFound{
		Patient patient = null;
		Optional<Patient> optionalPatient = ipatientRepository.findById(id);
		if(optionalPatient.isPresent())
			patient = optionalPatient.get();
		else
			throw new DataNotFound("Data is not found!! Please register your name.");
		return patient;
	}

	@Override
	public List<TestResult> getAllTestResult(String patientUserName) throws InvalidUserName, DataNotFound {

		if(ipatientRepository.findByName(patientUserName) != null) {
			List<TestResult> tr = qc.getAllTestResult(patientUserName);
			if(tr.size() == 0) {
				throw new DataNotFound("No Test Results found....");}
			else
				return tr;
		}
		else
			throw new InvalidUserName("Please Enter Valid User Name....");
	}

	@Override
	public TestResult viewTestResult(int testResultId) throws DataNotFound{
		TestResult testr = null;
		Optional<TestResult> optionalTestResult = itestresultRepository.findById(testResultId);
		if(optionalTestResult.isPresent())
			testr = optionalTestResult.get();
		else
			throw new DataNotFound("You are not registered yet...Please Register Yourself...");
		return testr;
	}
	
	@Override
    public List<Patient> getAll() {
        System.out.println("PatientRepository Child Class Created By Spring Boot: " + ipatientRepository.getClass().getName());
        return ipatientRepository.findAll();
    }
	
}

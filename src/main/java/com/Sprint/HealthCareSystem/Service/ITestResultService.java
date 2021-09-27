package com.Sprint.HealthCareSystem.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Sprint.HealthCareSystem.Entity.DiagnosticTest;
import com.Sprint.HealthCareSystem.Entity.Patient;
import com.Sprint.HealthCareSystem.Entity.TestResult;
import com.Sprint.HealthCareSystem.Exceptions.DataAlreadyExists;
import com.Sprint.HealthCareSystem.Exceptions.DataNotFound;
import com.Sprint.HealthCareSystem.Exceptions.TestResultNotFound;
import com.Sprint.HealthCareSystem.Repository.ITestResultRepository;
import com.Sprint.HealthCareSystem.Repository.Queries.QueryClass;

@Service
public class ITestResultService implements TestResultService {
	@Autowired
	private ITestResultRepository itestResultRepository;
	
	@Autowired(required = false)
	QueryClass qc;

	@Override
	public TestResult addTestResult(TestResult tr) throws DataAlreadyExists{
		
		if(itestResultRepository.existsById(tr.getId())) 
			throw new DataAlreadyExists("Test Result Already exists with id :"+tr.getId());
		return itestResultRepository.saveAndFlush(tr);
	}

	@Override
	public TestResult updateResult(TestResult tr) throws DataNotFound {
		if(!itestResultRepository.existsById(tr.getId()))
			throw new DataNotFound("TestResult Not Found in DataBase to update");
		return itestResultRepository.saveAndFlush(tr);
	}

	@Override
	public List<TestResult> removeTest(DiagnosticTest test) throws TestResultNotFound {
		if(!itestResultRepository.existsById(test.getId())) 
			throw new TestResultNotFound("Test Result Does Not Exist  "+ test.getId());
		//TestResult tr = itestResultRepository.findById(test.getId()).get();
		itestResultRepository.deleteById(test.getId());
		return itestResultRepository.findAll();
		
	}
	
	@Override
	public List<TestResult> viewResultsByPatient(Patient patient) throws DataNotFound, TestResultNotFound {
		List<TestResult> testRes =  qc.viewResultsByPatient(patient);
		if(testRes.size() ==0 )throw new DataNotFound("User/Tests Doesn't Exits");
		return testRes;
	}

	@Override
	public List<TestResult> getAll() {
		return itestResultRepository.findAll();
	}
	@Override
	public TestResult getById(int id) throws DataNotFound {
		return itestResultRepository.findById(id).orElseThrow(()-> new DataNotFound("No Patient With ID "+id));
	}

}

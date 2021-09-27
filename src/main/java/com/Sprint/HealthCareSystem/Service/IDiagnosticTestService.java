package com.Sprint.HealthCareSystem.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Sprint.HealthCareSystem.Entity.DiagnosticTest;
import com.Sprint.HealthCareSystem.Exceptions.DataAlreadyExists;
import com.Sprint.HealthCareSystem.Exceptions.DataNotFound;
import com.Sprint.HealthCareSystem.Repository.IDiagnosticTestRepository;
import com.Sprint.HealthCareSystem.Repository.Queries.QueryClass;

@Service
public class IDiagnosticTestService implements DiagnosticTestService {
	@Autowired
	private IDiagnosticTestRepository idiagnosticTestRepository;
	@Autowired(required = false)
	private QueryClass qc;

	@Override
	public List<DiagnosticTest> getAllTest() {
		return idiagnosticTestRepository.findAll();
	}

	@Override
	public DiagnosticTest addNewTest(DiagnosticTest test) throws DataAlreadyExists {
		if(idiagnosticTestRepository.existsById(test.getId())) 
			throw new DataAlreadyExists("Test Already Exists. Use Update To Change");
		return idiagnosticTestRepository.saveAndFlush(test);
	}

	@Override
	public List<DiagnosticTest> getTestsOfDiagnosticCenter(int centerId) throws DataNotFound {
		List<DiagnosticTest> tests = qc.getTestsOfDiagnosticCenter(centerId);
		if(tests.size()==0)
			throw new DataNotFound("No Diagnostic Tests Exist");
		return tests;
	}

	@Override
	public DiagnosticTest updateTestDetail(DiagnosticTest test) throws DataNotFound {

		if(!idiagnosticTestRepository.existsById(test.getId())) 
			throw new DataNotFound("No test Exist with id : "+test.getId()+" To Update");
		
		return idiagnosticTestRepository.saveAndFlush(test);
	}

//	@Override
//	public DiagnosticTest removeTestFromDiagnosticCenter(int centerId, DiagnosticTest test) throws Exception {
//		return qc.removeTestFromDiagnosticCenter(centerId, test);
//	}

}

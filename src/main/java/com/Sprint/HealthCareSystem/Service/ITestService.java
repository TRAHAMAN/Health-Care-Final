package com.Sprint.HealthCareSystem.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sprint.HealthCareSystem.Entity.DiagnosticCenter;
import com.Sprint.HealthCareSystem.Entity.DiagnosticTest;
import com.Sprint.HealthCareSystem.Exceptions.DataNotFound;
import com.Sprint.HealthCareSystem.Repository.IDiagnosticCenterRepository;
import com.Sprint.HealthCareSystem.Repository.ITestServiceRepository;
import com.Sprint.HealthCareSystem.Repository.Queries.QueryClass;

@Service
public class ITestService implements TestService{
	@Autowired
	private ITestServiceRepository itestRepository;
	
	@Autowired(required = false)
	QueryClass qc;

	@Autowired
	private IDiagnosticCenterRepository centerRepo;
	

	@Override
	public DiagnosticTest addTest(DiagnosticTest test) throws DataNotFound {
		if(!itestRepository.existsById(test.getId())) throw new DataNotFound("Test Already Exists");
		return itestRepository.saveAndFlush(test);
	}

	@Override
	public DiagnosticTest updateTest(DiagnosticTest test) throws DataNotFound {
		if(!itestRepository.existsById(test.getId())) throw new DataNotFound("Test Does Not Exist");
		return itestRepository.saveAndFlush(test);
	}

	@Override
	public DiagnosticTest removeTest(int diagnosticTestid) throws DataNotFound {
		if(!itestRepository.existsById(diagnosticTestid)) 
			throw new DataNotFound("Test Does Not Exist");
		DiagnosticTest tes = itestRepository.findById(diagnosticTestid).get();
		itestRepository.delete(tes);
		return tes;
	}

	@Override
	public List<DiagnosticTest> viewAllTest() {
		return itestRepository.findAll();
	}

//	@Override
//	public DiagnosticTest addTestInCenter(int testId, int centerId) throws DataNotFound{
//		DiagnosticTest test = itestRepository.findById(testId)
//				.orElseThrow(()-> new DataNotFound(testId+" test Not Found"));
//		DiagnosticCenter center = centerRepo.findById(centerId)
//				.orElseThrow(()-> new DataNotFound(centerId+" center Not Found"));
//		test.setDiagnosticCenters(center);
//		center.getTests().add(test);
//		itestRepository.save(test);
//		return test;
//	}


}

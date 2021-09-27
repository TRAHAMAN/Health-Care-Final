package com.Sprint.HealthCareSystem.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Sprint.HealthCareSystem.Entity.DiagnosticTest;
import com.Sprint.HealthCareSystem.Exceptions.DataAlreadyExists;
import com.Sprint.HealthCareSystem.Exceptions.DataNotFound;

@Service
public interface DiagnosticTestService {
	
	public List<DiagnosticTest> getAllTest();
	public DiagnosticTest addNewTest(DiagnosticTest test) throws DataAlreadyExists;
	public List<DiagnosticTest> getTestsOfDiagnosticCenter(int centerId) throws DataNotFound;
	public DiagnosticTest updateTestDetail(DiagnosticTest test) throws DataNotFound;
	//public DiagnosticTest removeTestFromDiagnosticCenter(int centerId, DiagnosticTest test) throws Exception;
	
}

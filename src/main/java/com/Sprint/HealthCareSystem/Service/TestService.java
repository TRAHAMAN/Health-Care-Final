package com.Sprint.HealthCareSystem.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Sprint.HealthCareSystem.Entity.DiagnosticTest;
import com.Sprint.HealthCareSystem.Exceptions.DataNotFound;


@Service
public interface TestService {

	public DiagnosticTest addTest(DiagnosticTest test) throws DataNotFound;

	public DiagnosticTest updateTest(DiagnosticTest test) throws DataNotFound;

	public DiagnosticTest removeTest(int diagnosticTestid) throws DataNotFound;

	public List<DiagnosticTest> viewAllTest();

//	public DiagnosticTest addTestInCenter(int testId, int centerId) throws DataNotFound;
	

}

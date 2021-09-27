package com.Sprint.HealthCareSystem.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Sprint.HealthCareSystem.Entity.Appointment;
import com.Sprint.HealthCareSystem.Entity.DiagnosticCenter;
import com.Sprint.HealthCareSystem.Entity.DiagnosticTest;
import com.Sprint.HealthCareSystem.Exceptions.DataAlreadyExists;
import com.Sprint.HealthCareSystem.Exceptions.DataNotFound;
import com.Sprint.HealthCareSystem.Exceptions.DiagnosticCentreNotFound;

@Service
public interface DiagnosticCenterService {
	
	public List<DiagnosticCenter> getAllDiagnosticCenters();
	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter diagnosticCenter) throws DataAlreadyExists;
	public DiagnosticCenter getDiagnosticCenterById(int diagcentreId) throws DataNotFound;
	public DiagnosticCenter updateDiagnosticCenter(DiagnosticCenter diagnosticCenter) throws DataNotFound;
	public DiagnosticTest addTest(int diagcentreId,int testId);
	//public DiagnosticCenter getDiagnosticCenter(String centername) throws DataNotFound; 
	public DiagnosticCenter removeDiagnosticCenter(int id) throws DiagnosticCentreNotFound;
	public List<Appointment> getListOfAppointments(String centername);
	public List<DiagnosticTest> viewTestDetails(int diagcentreId) throws DataNotFound;
}


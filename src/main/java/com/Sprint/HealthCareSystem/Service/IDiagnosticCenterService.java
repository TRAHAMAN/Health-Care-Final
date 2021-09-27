package com.Sprint.HealthCareSystem.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Sprint.HealthCareSystem.Entity.Appointment;
import com.Sprint.HealthCareSystem.Entity.DiagnosticCenter;
import com.Sprint.HealthCareSystem.Entity.DiagnosticTest;
import com.Sprint.HealthCareSystem.Exceptions.DataAlreadyExists;
import com.Sprint.HealthCareSystem.Exceptions.DataNotFound;
import com.Sprint.HealthCareSystem.Exceptions.DiagnosticCentreNotFound;
import com.Sprint.HealthCareSystem.Repository.IAppointmentRepository;
import com.Sprint.HealthCareSystem.Repository.IDiagnosticCenterRepository;
import com.Sprint.HealthCareSystem.Repository.Queries.QueryClass;

@Service
public class IDiagnosticCenterService implements DiagnosticCenterService{
	@Autowired
	private IDiagnosticCenterRepository idiagnosticCenterRepository;
	@Autowired
	private IAppointmentRepository iappointmentRepository;
	@Autowired(required = false)
	QueryClass qc;

	@Override
	public List<DiagnosticCenter> getAllDiagnosticCenters() {
		return idiagnosticCenterRepository.findAll();
	}

	@Override
	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter diagnosticCenter) 
			throws DataAlreadyExists {
		if(idiagnosticCenterRepository.existsById(diagnosticCenter.getDid()))
			throw new DataAlreadyExists(" Diagnostic Center Already Exists, Id: "+ diagnosticCenter.getDid());
		else
			idiagnosticCenterRepository.save(diagnosticCenter);
			return diagnosticCenter;
	}

	@Override
	public DiagnosticCenter getDiagnosticCenterById(int diagcentreId) throws DataNotFound {
		DiagnosticCenter diagc = null;
		Optional<DiagnosticCenter> optionalDiagnosticCenter = idiagnosticCenterRepository.findById(diagcentreId);
		if(optionalDiagnosticCenter.isPresent())
			diagc = optionalDiagnosticCenter.get();
		else
			throw new DataNotFound("No Diagnostic Center Found with the ID: "+ diagcentreId);
			return diagc;
	}

	@Override
	public DiagnosticCenter updateDiagnosticCenter(DiagnosticCenter diagnosticCenter) throws DataNotFound {
		if(!idiagnosticCenterRepository.existsById(diagnosticCenter.getDid())) 
			throw new DataNotFound("Diagnostic Center Not Found");
		idiagnosticCenterRepository.saveAndFlush(diagnosticCenter);
		return diagnosticCenter;
	}

	@Override
	public List<DiagnosticTest> viewTestDetails(int diagcentreId) throws DataNotFound {
		if(idiagnosticCenterRepository.existsById(diagcentreId))			
			return qc.viewTestDetails(diagcentreId);
		else
			throw new DataNotFound("Diagnostic Center with Id: "+diagcentreId+" is not available.");
	}

	@Override
	public DiagnosticTest addTest(int diagcentreId, int testId) {
		
		return null;
	}

//	@Override
//	public DiagnosticCenter getDiagnosticCenter(String centername) throws DataNotFound {
//		DiagnosticCenter dc = idiagnosticCenterRepository.getDiagnosticCenter(centername);
//		if(dc == null) 
//			throw new DataNotFound("Diagnostic Center Not Found");
//		return dc;
//	}

	@Override
	public DiagnosticCenter removeDiagnosticCenter(int id) throws DiagnosticCentreNotFound {
		Optional<DiagnosticCenter> op = idiagnosticCenterRepository.findById(id);
		if(op.isPresent()) {
			idiagnosticCenterRepository.deleteById(id);
			return op.get();
		}
		else 
			throw new DiagnosticCentreNotFound("Diagnostic Center not found with Id: "+id);
		
	}

	@Override
	public List<Appointment> getListOfAppointments(String centername) {
		return iappointmentRepository.findAll();
		

	}

}

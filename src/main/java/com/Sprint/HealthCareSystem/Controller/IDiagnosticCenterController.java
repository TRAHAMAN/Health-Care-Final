package com.Sprint.HealthCareSystem.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Sprint.HealthCareSystem.Entity.DiagnosticCenter;
import com.Sprint.HealthCareSystem.Exceptions.DataAlreadyExists;
import com.Sprint.HealthCareSystem.Service.DiagnosticCenterService;
import com.Sprint.HealthCareSystem.Service.IDiagnosticCenterService;


@RestController
@RequestMapping("diagnostic_center_details")
public class IDiagnosticCenterController {
	@Autowired
	private DiagnosticCenterService diagnosticCenterService;
	
	@GetMapping("/getall")
	public List<DiagnosticCenter> getAllDiagnosticCenters(){
		return diagnosticCenterService.getAllDiagnosticCenters();
	}
	@PostMapping("/add")
	public ResponseEntity<DiagnosticCenter> addDiagnosticCenter(@RequestBody DiagnosticCenter diagnosticCenter) throws DataAlreadyExists{
		DiagnosticCenter app = diagnosticCenterService.addDiagnosticCenter(diagnosticCenter);
		System.out.println(System.currentTimeMillis());
		return new ResponseEntity<DiagnosticCenter>(app, HttpStatus.CREATED);
	}

}

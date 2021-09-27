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
import com.Sprint.HealthCareSystem.Entity.DiagnosticTest;
import com.Sprint.HealthCareSystem.Exceptions.DataAlreadyExists;
import com.Sprint.HealthCareSystem.Service.DiagnosticTestService;


@RestController
@RequestMapping("diagnostic_test_details")
public class IDiagnosticTestController {
	
	@Autowired
	private DiagnosticTestService diagnosticTestService;
	
	@GetMapping("/getall")
	public List<DiagnosticTest> getAllTest(){
		return diagnosticTestService.getAllTest();
	}
	@PostMapping("/add")
	public ResponseEntity<DiagnosticTest> addNewTest(@RequestBody DiagnosticTest diagnosticTest) throws DataAlreadyExists{
		DiagnosticTest app = diagnosticTestService.addNewTest(diagnosticTest);
		System.out.println(System.currentTimeMillis());
		return new ResponseEntity<DiagnosticTest>(app, HttpStatus.CREATED);
	}

}

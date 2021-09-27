package com.Sprint.HealthCareSystem.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Sprint.HealthCareSystem.Entity.DiagnosticTest;
import com.Sprint.HealthCareSystem.Entity.Patient;
import com.Sprint.HealthCareSystem.Entity.TestResult;
import com.Sprint.HealthCareSystem.Exceptions.DataAlreadyExists;
import com.Sprint.HealthCareSystem.Exceptions.DataNotFound;
import com.Sprint.HealthCareSystem.Exceptions.TestResultNotFound;
import com.Sprint.HealthCareSystem.Service.ITestResultService;

@RestController
@RequestMapping("TestResult")
public class ITestResultController {
	@Autowired
	private ITestResultService testresultService;

	@Autowired
	LoginController logCon;

	@PostMapping("/addresult")
	public TestResult addTestResult(@RequestBody TestResult tr) throws DataAlreadyExists {
		return testresultService.addTestResult(tr);
	}

	@PutMapping("/updateresult")
	public TestResult updateResult(@RequestBody TestResult tr) throws DataNotFound {
		return testresultService.updateResult(tr);
	}

//	@DeleteMapping("/removeresult/{id}")
//	public List<TestResult> removeTest(@PathVariable DiagnosticTest test) throws TestResultNotFound {
//		return testresultService.removeTest(test);
//	}

	@GetMapping("/viewresultsbypatient/{patientID}")
	public List<TestResult> viewResultsByPatient(@PathVariable int patientID) throws Exception {
		Patient pat = new Patient();
		try {
			pat.setPatientId(patientID);
		} catch (Exception e) {
			throw new Exception("This is Not An ID");
		}
		return testresultService.viewResultsByPatient(pat);
	}
	
	@GetMapping("/getAllTestResults")
	public List<TestResult> getAllTestResults(){
		return testresultService.getAll();
	}
	@GetMapping("/resultbyid/{id}")
	public TestResult getById(@PathVariable int id) throws DataNotFound {
		return testresultService.getById(id);
	}

}

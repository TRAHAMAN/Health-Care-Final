package com.Sprint.HealthCareSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Sprint.HealthCareSystem.Entity.DiagnosticTest;
import com.Sprint.HealthCareSystem.Exceptions.DataNotFound;
import com.Sprint.HealthCareSystem.Service.TestService;

@RestController
@RequestMapping("Test")
public class ITestController {
	@Autowired
	TestService testService;

	@Autowired
	LoginController logCon;

	@PostMapping("/addtest")
	public DiagnosticTest addTest(@RequestBody DiagnosticTest test) throws DataNotFound {
		return testService.addTest(test);
	}

	@PutMapping("/updatetest")
	public DiagnosticTest updateTest(@RequestBody DiagnosticTest test)
			throws DataNotFound {
		return testService.updateTest(test);
	}

	@DeleteMapping("/removetest/{diagnosticTestid}")
	public DiagnosticTest removeTest(@PathVariable int diagnosticTestid) throws DataNotFound {
		return testService.removeTest(diagnosticTestid);
	}

	@GetMapping("/viewalltest")
	public List<DiagnosticTest> viewAllTest() {
		return testService.viewAllTest();
	}

//	@PostMapping("/addtestincenter")
//	public DiagnosticTest addTestInCenter(@RequestParam int testID, @RequestParam int centerId)
//			throws DataNotFound {
//		return testService.addTestInCenter(testID, centerId);
//	}

}

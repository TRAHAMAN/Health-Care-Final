package com.Sprint.HealthCareSystem.Controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Sprint.HealthCareSystem.Entity.Patient;
import com.Sprint.HealthCareSystem.Exceptions.DataAlreadyExists;
import com.Sprint.HealthCareSystem.Exceptions.DataNotFound;
import com.Sprint.HealthCareSystem.Service.PatientService;

@RestController
@RequestMapping("patientdetails")
public class IPatientController {
	@Autowired
	private PatientService patientService;
	@GetMapping("/getall")
	public List<Patient> getPatients(){
		return patientService.getAll();
	}
	@PostMapping("/create")
	public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) throws DataAlreadyExists{
		Patient pt = patientService.registerPatient(patient);
		System.out.println(System.currentTimeMillis());
		return new ResponseEntity<Patient>(pt, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Patient> updatePatientDetails(@RequestBody int id, @RequestBody Patient patient) throws DataNotFound{
		Patient pt = patientService.updatePatientDetails(id, patient);
		System.out.println(System.currentTimeMillis());
		return new ResponseEntity<Patient>(pt, HttpStatus.CREATED);
	}
	@GetMapping("/viewdetails")
	public ResponseEntity<Patient> viewPatientDetails(@RequestBody int id) throws DataNotFound {
		Patient pt = patientService.viewPatient(id);
		System.out.println(System.currentTimeMillis());
		return new ResponseEntity<Patient>(pt, HttpStatus.CREATED);
	}
	/*@DeleteMapping("/delete")
	public ResponseEntity<Patient> removePatientDetails(@RequestBody int id, @RequestBody Patient patient) throws DataNotFound{
		Patient pt = patientService.updatePatientDetails(id, patient);
		System.out.println(System.currentTimeMillis());
		return new ResponseEntity<Patient>(pt, HttpStatus.CREATED);
	}*/
}

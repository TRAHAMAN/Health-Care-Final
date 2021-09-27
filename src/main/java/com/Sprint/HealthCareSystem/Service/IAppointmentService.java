package com.Sprint.HealthCareSystem.Service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Sprint.HealthCareSystem.Entity.Appointment;
import com.Sprint.HealthCareSystem.Entity.ApprovalStatus;
import com.Sprint.HealthCareSystem.Exceptions.AppointmentAlreadyProvided;
import com.Sprint.HealthCareSystem.Exceptions.AppointmentNotFound;
import com.Sprint.HealthCareSystem.Exceptions.InvalidAppointmentStatusException;
import com.Sprint.HealthCareSystem.Repository.IAppointmentRepository;
import com.Sprint.HealthCareSystem.Repository.IPatientRepository;
import com.Sprint.HealthCareSystem.Repository.Queries.QueryClass;

@Service
public class IAppointmentService  implements AppointmentService{
	@Autowired
	private IAppointmentRepository iappointmentRepository;
	@Autowired	
	private IPatientRepository ipatientRepository;
	@Autowired(required = false)
	private QueryClass qc;
	
	@Override
	public Appointment addAppointment(Appointment appointment) throws AppointmentAlreadyProvided{
		if(iappointmentRepository.existsById(appointment.getId())) {
			throw new AppointmentAlreadyProvided("Your Appointment is already scheduled..");
			
		}
		else {
			iappointmentRepository.save(appointment);
			return appointment;
		}
	}


	@Override
	public Appointment viewAppointment(int appId) throws AppointmentNotFound {
		Appointment appointment = null;
		Optional<Appointment> optionalAppointment = iappointmentRepository.findById(appId);
		if(optionalAppointment.isPresent())
			appointment = optionalAppointment.get();
		else
			throw new AppointmentNotFound("You have no appointments to view...");
		return appointment;
	}

	@Override
	public Appointment updateAppointment(int appid, Appointment appointment) throws AppointmentNotFound{
		Appointment app = null;
		Optional<Appointment> optionalAppointment = iappointmentRepository.findById(appid);
		if(optionalAppointment.isPresent())
			app = optionalAppointment.get();
		else
			throw new AppointmentNotFound("You have not taken any appointment");
		app.setAppointmentDate(appointment.getAppointmentDate());
		app.setApprovalStatus(appointment.getApprovalStatus());
		app.setDiagnosticTests(appointment.getDiagnosticTests());
		app.setPatient(appointment.getPatient());
		app.setDiagnosticCenter(appointment.getDiagnosticCenter());
		app.setTestResult(appointment.getTestResult());
		System.out.println("Appointment Details Updated Successfully !!!");
		return appointment;
	}

	@Override
	public List<Appointment> getAppointmentList(int centreId, String test, String status) throws InvalidAppointmentStatusException, AppointmentNotFound {
		ApprovalStatus stat;
		try {
			 stat = ApprovalStatus.valueOf(status);
		}
		catch(Exception e) {
			throw new InvalidAppointmentStatusException("Invaild AppointMent Status"+status);
		}
		List<Appointment> apps = qc.getAppointmentList(centreId, test,stat);
		if(apps.size() == 0) throw new AppointmentNotFound("No Such Appointment Exists");
		return apps;
	}

	@Override
	public Appointment removeAppointment(int appId, Appointment appointment) throws AppointmentNotFound {
		if(iappointmentRepository.existsById(appId)) {
			iappointmentRepository.deleteById(appId);
			return appointment;
		}
		else {
			throw new AppointmentNotFound("You have no appointments to delete.....");
		}
	}

	@Override
	public List<Appointment> viewAppointments(String patientName) throws AppointmentNotFound {

		if(ipatientRepository.findByName(patientName) != null) {
			List<Appointment> vapp = qc.viewAppointments(patientName);			
			return vapp;
		}
		else {
			throw new AppointmentNotFound("You have no appointments...");
		}

	}
	
	@Override
    public List<Appointment> getAll() {
        System.out.println("AppointmentRepository Child Class Created By Spring Boot: " + iappointmentRepository.getClass().getName());
        return iappointmentRepository.findAll();
    }

}

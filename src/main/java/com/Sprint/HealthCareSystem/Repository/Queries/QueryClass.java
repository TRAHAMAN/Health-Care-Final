package com.Sprint.HealthCareSystem.Repository.Queries;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.Sprint.HealthCareSystem.Entity.Appointment;
import com.Sprint.HealthCareSystem.Entity.ApprovalStatus;
import com.Sprint.HealthCareSystem.Entity.DiagnosticCenter;
import com.Sprint.HealthCareSystem.Entity.DiagnosticTest;
import com.Sprint.HealthCareSystem.Entity.Patient;
import com.Sprint.HealthCareSystem.Entity.TestResult;
import com.Sprint.HealthCareSystem.Entity.User;
import com.Sprint.HealthCareSystem.Exceptions.TestResultNotFound;
import com.Sprint.HealthCareSystem.Exceptions.UserNotFound;


public class QueryClass {
	@PersistenceContext
	EntityManager eManager;
	
	public List<Appointment> getAppointmentList(int centreId, String test, ApprovalStatus status){
		TypedQuery<Appointment> gal = eManager.createQuery("select a from Appointment a join a.diagnosticTests d where"
				+ " a.diagnosticCenter.diagonasticCenterid = :did and d.testName like :testName and a.approvalStatus like :status", Appointment.class);
		gal.setParameter("did", centreId);
		gal.setParameter("testName",test);
		gal.setParameter("status",status);
		List<Appointment> result = gal.getResultList();
		return result;
	}
	public List<Appointment> viewAppointments( String patientName){
		TypedQuery<Appointment> vap = eManager.createQuery("select a from Appointment a where a.patient.name like :pname",Appointment.class);
		vap.setParameter("pname",patientName);
		return vap.getResultList();
	}
//	public List<Appointment> getListOfAppointments(String centername){
//		TypedQuery<Appointment> gla = eManager.createQuery("select a from Appointment a join a.diagnosticCenter dc where"
//				+ "a.diagnosticCenter.diagonasticCentername like :centername ",Appointment.class);
//		gla.setParameter("cname",centername);
//		return gla.getResultList();
//	}
	public List<TestResult> getAllTestResult(String patientUserName) {
		TypedQuery<TestResult> gatr = eManager.createQuery("select t from TestResult t join t.appointment a where a.patient.name like :n",TestResult.class);
		gatr.setParameter("n", patientUserName);
		List<TestResult> tr = gatr.getResultList();
		return tr;
	}
	public User findByUserName(String username) throws UserNotFound {
		TypedQuery<User> qry = eManager.createQuery("select u from User u where u.username like :name",User.class);
		qry.setParameter("name", username);
		List<User> user = qry.getResultList();
		if(user.size()==0)
			throw new UserNotFound("User Not Available !!"+username);
		return user.get(0);
	}
	public List<TestResult> viewResultsByPatient(Patient patient) throws TestResultNotFound {
		TypedQuery<TestResult> qry = eManager.createQuery("select t from TestResult t join t.appointment a where a.patient.id = :id",TestResult.class);
		qry.setParameter("id", patient.getPatientId());
		List<TestResult> tr = qry.getResultList();
		if(tr.size()==0)
			throw new TestResultNotFound("Test Result Not Found");
		return tr;
	}
	public List<DiagnosticTest> getTestsOfDiagnosticCenter(int centerId){

		TypedQuery<DiagnosticTest> exe = eManager.createQuery("select d from DiagnosticTest d join d.diagnosticCenter dc where dc.diagonasticCenterid like :id", DiagnosticTest.class);
		exe.setParameter("id", centerId);
		List<DiagnosticTest> resultList = exe.getResultList();
		return resultList;
	}
	public List<DiagnosticTest> viewTestDetails(int diagnosticCenterId) {
		TypedQuery<DiagnosticTest> q= eManager.createQuery("select a from DiagnosticTest a join a.diagnosticCenter d "
				+ " where d.diagonasticCenterid = :id",DiagnosticTest.class);
		q.setParameter("id", diagnosticCenterId);
		return q.getResultList();
	}
//	public DiagnosticTest removeTestFromDiagnosticCenter(int centerId, int test) {
//		TypedQuery<DiagnosticTest> qry = eManager.createQuery("select c from DiagnosticCenter c where c.diagonasticCenterid = :id");
//		qry.setParameter("id", centerId);
//		DiagnosticCenter diagnosticCenter = (DiagnosticCenter) qry.getSingleResult();
//		qry = eManager.createQuery("select t from DiagnosticTest t where t.diagonasticTestid = :tid");
//		qry.setParameter("tid", test);
//		DiagnosticTest diagnosticTest = (DiagnosticTest) qry.getSingleResult();
//		diagnosticTest.setDiagnosticCenter(null);
//		diagnosticCenter.getTests().remove(diagnosticTest);
//		eManager.persist(diagnosticTest);
//		eManager.persist(diagnosticCenter);
//		return diagnosticTest;
//	}
	


}

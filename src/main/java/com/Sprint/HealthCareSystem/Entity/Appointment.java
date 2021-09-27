package com.Sprint.HealthCareSystem.Entity;

import java.util.*;
import java.time.LocalDate;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "Appointments")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "App_ID")
	private int id;
	private LocalDate appointmentDate;
	private ApprovalStatus approvalStatus;
	
//	@OneToMany(targetEntity = DiagnosticTest.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "app_diag_test", referencedColumnName = "DiagT_ID")
	@OneToMany
	private Set<DiagnosticTest> diagnosticTests;
	
	@ManyToOne(targetEntity = Patient.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pat_app", referencedColumnName = "P_ID")
	private Patient patient;
	
	@OneToOne(targetEntity = DiagnosticCenter.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "app_diag_center", referencedColumnName = "DiagC_ID")
	private DiagnosticCenter diagnosticCenter;
	
//	@OneToMany(targetEntity = TestResult.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "app_test_result", referencedColumnName = "Test_R_ID")
	@OneToMany(mappedBy = "appointment",cascade = CascadeType.REMOVE)
	private List<TestResult> testResult;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public ApprovalStatus getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(ApprovalStatus approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public Set<DiagnosticTest> getDiagnosticTests() {
		return diagnosticTests;
	}
	public void setDiagnosticTests(Set<DiagnosticTest> diagnosticTests) {
		this.diagnosticTests = diagnosticTests;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public DiagnosticCenter getDiagnosticCenter() {
		return diagnosticCenter;
	}
	public void setDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		this.diagnosticCenter = diagnosticCenter;
	}
	public List<TestResult> getTestResult() {
		return testResult;
	}
	public void setTestResult(List<TestResult> testResult) {
		this.testResult = testResult;
	}
}

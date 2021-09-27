package com.Sprint.HealthCareSystem.Entity;

import java.util.*;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "Test_Result")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestResult {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Test_R_ID")
	private int tid;
	@Column(name = "Test_R_Test_Reading" , length = 4)
	private double testReading;
	@Column(name = "Test_R_Condition", length = 10)
	private String condition;
	
//	@ManyToOne(targetEntity = Appointment.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "app_test_result", referencedColumnName = "App_ID")
	@ManyToOne
	private Appointment appointment;
	
	public int getId() {
		return tid;
	}
	public void setId(int tid) {
		this.tid = tid;
	}
	public double getTestReading() {
		return testReading;
	}
	public void setTestReading(double testReading) {
		this.testReading = testReading;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
//	public List<Appointment> getAppointment() {
//		return appointment;
//	}
//	public void setAppointment(List<Appointment> appointment) {
//		this.appointment = appointment;
//	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
}

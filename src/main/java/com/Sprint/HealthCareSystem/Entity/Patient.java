package com.Sprint.HealthCareSystem.Entity;

import javax.persistence.*;
import lombok.*;
import java.util.*;

@Data
@Entity
@Table(name = "Patient_Details")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "P_ID")
	private int patientId;
	@Column(name = "Name", nullable = false, length = 30)
	private String name;
	@Column(name = "Contacts", length = 10)
	private String phoneNo;
	@Column(name = "Age", length = 2)
	private int age;
	@Column(name = "Gender", length = 1)
	private String gender;
	
	@OneToOne(targetEntity = Appointment.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pat_app", referencedColumnName = "App_ID")
	private List<Appointment> appointments;
	
	public String getName() {
		return name;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	
}

package com.Sprint.HealthCareSystem.Entity;

import java.util.*;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "Diagnostic_Center")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DiagnosticCenter {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DiagC_ID")
	private int did;
	@Column(name = "DiagC_Name", nullable = false, length = 20)
	private String name;
	@Column(name = "DiagC_ContactNo", nullable = false, length = 11)
	private String contactNo;
	@Column(name = "DiagC_Address", length = 30)
	private String address;
	@Column(name = "DiagC_Email", length = 20)
	private String contactEmail;
	//private List<String> servicesOffered;
	
	@ManyToMany(targetEntity = DiagnosticTest.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "diagc_diagt", referencedColumnName = "DiagT_ID")
	private Set<DiagnosticTest> tests;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
//	public List<String> getServicesOffered() {
//		return servicesOffered;
//	}
//	public void setServicesOffered(List<String> servicesOffered) {
//		this.servicesOffered = servicesOffered;
//	}
	public Set<DiagnosticTest> getTests() {
		return tests;
	}
	public void setTests(Set<DiagnosticTest> tests) {
		this.tests = tests;
	}
	
	
}

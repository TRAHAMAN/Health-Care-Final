package com.Sprint.HealthCareSystem.Entity;

import java.util.*;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "Diagnostic_Test")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DiagnosticTest {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DiagT_ID")
	private int id;
	@Column(name = "DiagT_Name", nullable = false, length = 15)
	private String testName;
	@Column(name = "DiagT_Price", nullable = false, length = 5)
	private double testPrice;
	@Column(name = "DiagT_Normal_Val", length = 5)
	private String normalValue;
	@Column(name = "DiagT_Units", length = 5)
	private String units;
	
	@ManyToMany(targetEntity = DiagnosticCenter.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "diagc_diagt", referencedColumnName = "DiagC_ID")
	private Set<DiagnosticCenter> diagnosticCenters;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public double getTestPrice() {
		return testPrice;
	}
	public void setTestPrice(double testPrice) {
		this.testPrice = testPrice;
	}
	public String getNormalValue() {
		return normalValue;
	}
	public void setNormalValue(String normalValue) {
		this.normalValue = normalValue;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public Set<DiagnosticCenter> getDiagnosticCenters() {
		return diagnosticCenters;
	}
	public void setDiagnosticCenters(Set<DiagnosticCenter> diagnosticCenters) {
		this.diagnosticCenters = diagnosticCenters;
	}
	
}

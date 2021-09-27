package com.Sprint.HealthCareSystem.Repository;

//import com.Sprint.HealthCareSystem.Entity.DiagnosticTest;

public interface DiagnosticCenterRepository {
	boolean existsByName(String centername);

	//DiagnosticCenter getDiagnosticCenter(String centername);

	boolean findByName(String centername);


}

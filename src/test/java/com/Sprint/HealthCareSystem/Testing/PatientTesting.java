package com.Sprint.HealthCareSystem.Testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.Sprint.HealthCareSystem.Entity.Patient;

@SpringBootTest
public class PatientTesting {
	Patient pat = new Patient("MAN", "1234567890", 23, "MALE", null);


	/** 
	 * @throws Exception
	 */
	@Override
	@BeforeEach
	public void setUp() throws Exception {
		super.setUp();
	}


	/** 
	 * @throws Exception
	 */
	@Test
	public void addPatient() throws Exception{
		String uri = "/patient/registerpatient";
		String inputJson = super.mapToJson(pat);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());

	}


	/** 
	 * @throws Exception
	 */
	@Test
	public void viewPatient() throws Exception{
		String uri = "/patient/viewpatient/MAN";
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri))
				.andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
	}

}

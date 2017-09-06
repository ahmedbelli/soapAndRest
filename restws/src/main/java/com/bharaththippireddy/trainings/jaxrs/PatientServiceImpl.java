package com.bharaththippireddy.trainings.jaxrs;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

public class PatientServiceImpl implements PatientService {
	private long currentId = 123;
	Map<Long, Patient> patients = new HashMap<Long, Patient>();
	Map<Long, Prescription> prescriptions = new HashMap<Long, Prescription>();

	public PatientServiceImpl() {
		init();
	}

	final void init() {
		Patient patient = new Patient();
		patient.setName("John");
		patient.setId(currentId);
		patients.put(patient.getId(), patient);

		Prescription prescription = new Prescription();
		prescription.setDescription("prescription 223");
		prescription.setId(223);
		prescriptions.put(prescription.getId(), prescription);
	}

	public Response addPatient(Patient patient) {
		System.out.println("......invoking addPatient: " + patient.getName());
		patient.setId(++currentId);
		patients.put(patient.getId(), patient);
		return Response.ok(patient).build();
	}

	public Patient getPatient(String id) {
		System.out.println("......invoking getPatient: " + id);
		Long idL = Long.parseLong(id);
		Patient patient = patients.get(idL);
		return patient;
	}

	public Response updatePatient(Patient updatedPatient) {
		System.out.println("......invoking updatePatient: " + updatedPatient.getId());
		Patient patient = patients.get(updatedPatient.getId());
		Response response = null;

		if (patient != null) {
			patients.put(updatedPatient.getId(), updatedPatient);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

	public Response deletePatients(String id) {
		System.out.println("......invoking deletePatients: " + id);
		Patient patient = patients.get(Long.parseLong(id));
		Response response = null;
		if(patient != null){
			patients.remove(Long.parseLong(id));
			response = Response.ok().build();
		} else{
			response = Response.notModified().build();
		}
		return response;
	}

	public Prescription getPrescription(String prescriptionId) {
		long id = Long.parseLong(prescriptionId);
		Prescription prescription = prescriptions.get(id);
		return prescription;
	}

}

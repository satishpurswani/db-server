package com.poc.dbserver.service.impl;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.dbserver.model.Patient;
import com.poc.dbserver.service.IPatientService;
import com.poc.dbserver.service.patient.repo.PatientRepository;

@Service
public class PatientService implements IPatientService{
	
	@Autowired
	private PatientRepository ipatientRepository;
	
	@PostConstruct
	public void testDataInset() {
		Patient patient = new Patient();
		patient.setName("Satish");
		patient.setAge(28);
		patient.setGender("M");
		patient.setAccessionNumber(new Long(1234));
		patient.setDob(new Date());
		ipatientRepository.save(patient);
	}
	
	@Override
	public boolean savePatientInformation(Patient patientDetails) {
		ipatientRepository.save(patientDetails);
		return false;
		
	}

}

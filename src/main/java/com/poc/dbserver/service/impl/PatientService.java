package com.poc.dbserver.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
		patient.setName("Satish1");
		patient.setAge(27);
		patient.setGender("O");
		patient.setAccessionNumber(new Long(12345));
		patient.setDob(new Date());
		ipatientRepository.save(patient);
	}
	
	@Override
	public boolean savePatientInformation(Patient patientDetails) {
		return ipatientRepository.save(patientDetails).getId().equals(patientDetails.getId());
	}
	
	public List<Patient> saveAll(List<Patient> patients) {
		return ipatientRepository.saveAll(patients);
	}
	
	public void deleteByID(Long id) throws EmptyResultDataAccessException{
		ipatientRepository.deleteById(id);
	}
	
	public Optional<Patient> getByPatientId(Long id) {
		return ipatientRepository.findById(id);
	}

	public boolean updatePatient(Long id, Patient patientDetails) {
		if(getByPatientId(id).isPresent()) {
			patientDetails.setId(id);
			return savePatientInformation(patientDetails);
		}
		return false;
	}
}

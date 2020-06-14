package com.poc.dbserver.service.impl;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.dbserver.model.Medication;
import com.poc.dbserver.service.IMedicationService;
import com.poc.dbserver.service.meds.repo.MedicationRepository;

@Service
public class MedicationService implements IMedicationService{
	
	@Autowired
	private MedicationRepository medicationRepository;
	
	@PostConstruct
	public void testDataInset() {
		Medication meds = new Medication();
		meds.setName("HQC");
		meds.setBatchNo("123");
		meds.setExpiryDate(new Date());
		medicationRepository.save(meds);
	}

	@Override
	public boolean saveMedsInformation(Medication medsDetails) {
		medicationRepository.save(medsDetails);
		return false;
	}
	

}

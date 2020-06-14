package com.poc.dbserver.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.dbserver.controller.IpatientDataController;
import com.poc.dbserver.model.Patient;
import com.poc.dbserver.service.IPatientService;

@RestController
@RequestMapping("/")
public class PatientDataController implements IpatientDataController{

	@Autowired
	IPatientService patientService;
	
	/*
	 * @PostMapping("/add/{patientDetails}") public boolean
	 * savePatientData(@RequestParam("patientDetails") Patient patientDetails) {
	 * boolean status = patientService.savePatientInformation(patientDetails);
	 * return status; }
	 */
}

package com.poc.dbserver.service.patient.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.dbserver.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}

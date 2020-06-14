package com.poc.dbserver.service.meds.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.dbserver.model.Medication;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long>{

}

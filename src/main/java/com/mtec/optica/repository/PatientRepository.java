package com.mtec.optica.repository;

import com.mtec.optica.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByNameContainingIgnoreCase(String name);
    List<Patient> findByPhoneContaining(String phone);
    List<Patient> findByEmailContainingIgnoreCase(String email);

    @Query("SELECT p FROM Patient p WHERE " +
            "LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(p.email) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "p.phone LIKE CONCAT('%', :searchTerm, '%') OR " +
            "LOWER(p.visitHistory) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Patient> searchPatients(@Param("searchTerm") String searchTerm);

    List<Patient> findByNextVisitDateBetween(LocalDate now, LocalDate endDate);
}


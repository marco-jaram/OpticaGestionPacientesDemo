package com.mtec.optica.service;

import com.mtec.optica.model.Patient;
import com.mtec.optica.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient updatePatient(Long id, Patient patientDetails) {
        return patientRepository.findById(id)
                .map(existingPatient -> {
                    existingPatient.setName(patientDetails.getName());
                    existingPatient.setAge(patientDetails.getAge());
                    existingPatient.setEmail(patientDetails.getEmail());
                    existingPatient.setPhone(patientDetails.getPhone());
                    existingPatient.setService(patientDetails.getService());
                    existingPatient.setProduct(patientDetails.getProduct());
                    existingPatient.setVisitHistory(patientDetails.getVisitHistory());

                    // Manejar lastVisitDate
                    if (patientDetails.getLastVisitDate() != null) {
                        existingPatient.setLastVisitDate(patientDetails.getLastVisitDate());
                    }

                    // Manejar nextVisitDate
                    if (patientDetails.getNextVisitDate() != null) {
                        existingPatient.setNextVisitDate(patientDetails.getNextVisitDate());
                    }

                    return patientRepository.save(existingPatient);
                })
                .orElse(null);
    }


    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public List<Patient> searchPatientsByName(String name) {
        return patientRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Patient> searchPatientsByPhone(String phone) {
        return patientRepository.findByPhoneContaining(phone);
    }

    public List<Patient> searchPatientsByEmail(String email) {
        return patientRepository.findByEmailContainingIgnoreCase(email);
    }
    public List<Patient> searchPatients(String searchTerm) {
        return patientRepository.searchPatients(searchTerm);
    }



    public List<Patient> getUpcomingVisits(int days) {
        LocalDate now = LocalDate.now();
        LocalDate endDate = now.plusDays(days);
        return patientRepository.findByNextVisitDateBetween(now, endDate);
    }



    public void scheduleNextVisit(Long patientId, LocalDate nextVisitDate) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        patient.setNextVisitDate(nextVisitDate);
        patientRepository.save(patient);
    }

    @Transactional
    public Patient addVisitHistoryEntry(Long patientId, String newEntry) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + patientId));

        String currentHistory = patient.getVisitHistory();
        if (currentHistory == null || currentHistory.isEmpty()) {
            patient.setVisitHistory(newEntry);
        } else {
            patient.setVisitHistory(currentHistory + "\n" + newEntry);
        }

        return patientRepository.save(patient);
    }

}

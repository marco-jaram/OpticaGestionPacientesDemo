package com.mtec.optica.controller;


import com.mtec.optica.model.Patient;
import com.mtec.optica.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.createPatient(patient));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatientById(@PathVariable String id) {
        try {
            long patientId = Long.parseLong(id);
            Optional<Patient> patient = patientService.getPatientById(patientId);
            if (patient == null) {
                Map<String, String> error = new HashMap<>();
                error.put("code", "PATIENT_NOT_FOUND");
                error.put("message", "Número de paciente no encontrado");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }
            return ResponseEntity.ok(patient);
        } catch (NumberFormatException e) {
            Map<String, String> error = new HashMap<>();
            error.put("code", "INVALID_INPUT");
            error.put("message", "Debe ingresar un número");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
        Patient updatedPatient = patientService.updatePatient(id, patientDetails);
        if (updatedPatient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPatient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/search")
    public ResponseEntity<List<Patient>> searchPatients(@RequestParam String searchTerm) {
        List<Patient> patients = patientService.searchPatients(searchTerm);
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/search/name")
    public ResponseEntity<List<Patient>> searchPatientsByName(@RequestParam String name) {
        List<Patient> patients = patientService.searchPatientsByName(name);
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/search/phone")
    public ResponseEntity<List<Patient>> searchPatientsByPhone(@RequestParam String phone) {
        List<Patient> patients = patientService.searchPatientsByPhone(phone);
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/search/email")
    public ResponseEntity<List<Patient>> searchPatientsByEmail(@RequestParam String email) {
        List<Patient> patients = patientService.searchPatientsByEmail(email);
        return ResponseEntity.ok(patients);
    }
//    notification
@GetMapping("/upcoming-visits")
public ResponseEntity<List<Patient>> getUpcomingVisits(@RequestParam(defaultValue = "7") int days) {
    List<Patient> upcomingVisits = patientService.getUpcomingVisits(days);
    return ResponseEntity.ok(upcomingVisits);
}
    @PostMapping("/{id}/visit-history")
    public ResponseEntity<Patient> addVisitHistoryEntry(@PathVariable Long id, @RequestBody String entry) {
        Patient updatedPatient = patientService.addVisitHistoryEntry(id, entry);
        return ResponseEntity.ok(updatedPatient);
    }
}

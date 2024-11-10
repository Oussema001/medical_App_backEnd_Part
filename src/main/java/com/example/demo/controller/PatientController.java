package com.example.demo.controller;

import com.example.demo.model.Medicament;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.PatientService;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController()
@RequestMapping("/api/patients")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
/*
    @PostMapping("/create")
    public Patient createPatient(
            @RequestParam String nom,
            @RequestParam String prenom,
            @RequestParam Date dateNaissance,
            @RequestParam String adresse,
            @RequestParam String email,
            @RequestParam String telephone) {
        return patientService.createPatient(nom, prenom, dateNaissance, adresse, email, telephone);
    }


 */
@PostMapping("/create")
public Patient createPatient(@RequestBody Patient patient1) {

    System.out.println("patient est"+patient1);
    return patientService.createPatient(patient1);
}


    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(
            @PathVariable("id") Long id, @RequestBody Patient patient) {

        // Appel du service pour mettre à jour le patient
        Patient updatedPatient = patientService.updatePatient(id, patient.getNom(), patient.getPrenom(), patient.getDateNaissance(), patient.getAdresse(), patient.getEmail(), patient.getTelephone());

        return ResponseEntity.ok(updatedPatient);
    }
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
    @GetMapping("/{id}")
    public Patient findPatientById(@PathVariable Long id) {
        return patientService.findPatientById(id);
    }

    @GetMapping("/getAll")
    public List<Patient> findAllPatients() {
        return patientService.findAllPatients();
    }
}

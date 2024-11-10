package com.example.demo.service;

import com.example.demo.model.Medicament;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;


import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PatientService {

    private PatientRepository patientRepository;


    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;

    }

    /*
        public Patient createPatient(String nom, String prenom, Date dateNaissance, String adresse, String email, String telephone) {
            Patient patient = new Patient();
            patient.setNom(nom);
            patient.setPrenom(prenom);
            patient.setDateNaissance(dateNaissance);
            patient.setAdresse(adresse);
            patient.setEmail(email);
            patient.setTelephone(telephone);

            return patientRepository.save(patient);
        }

     */
public Patient createPatient( Patient patient1) {


    return patientRepository.save(patient1);
}

    public Patient updatePatient(Long id, String nom, String prenom, Date dateNaissance, String adresse, String email, String telephone) {
        return patientRepository.findById(id).map(patient -> {
            patient.setNom(nom);
            patient.setPrenom(prenom);
            patient.setDateNaissance(dateNaissance);
            patient.setAdresse(adresse);
            patient.setEmail(email);
            patient.setTelephone(telephone);
            return patientRepository.save(patient);
        }).orElseThrow(() -> new IllegalArgumentException("Patient introuvable"));
    }


    public void deletePatient(Long id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
        }
    }


    public Patient findPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }


    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }
}

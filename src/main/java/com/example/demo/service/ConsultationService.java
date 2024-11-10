package com.example.demo.service;

import com.example.demo.model.Consultation;
import com.example.demo.repository.ConsultationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultationService {


    private ConsultationRepository consultationRepository;


   /* private PatientRepository patientRepository;*/



    public ConsultationService(ConsultationRepository consultationRepository) {
        //this.patientRepository = patientRepository;
        this.consultationRepository = consultationRepository;

    }
    public Consultation createConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    public Optional<Consultation> findConsultationById(Long id) {
        return consultationRepository.findById(id);
    }

    public List<Consultation> findAllConsultations() {
        return consultationRepository.findAll();
    }

    public Consultation updateConsultation(Long id, Consultation consultationDetails) {
        return consultationRepository.findById(id).map(consultation -> {
            consultation.setNom(consultationDetails.getNom());
            consultation.setNom(consultationDetails.getPrenom());
            consultation.setDate(consultationDetails.getDate());
            consultation.setMotif(consultationDetails.getMotif());

            return consultationRepository.save(consultation);
        }).orElseThrow(() -> new IllegalArgumentException("Consultation not found"));
    }

    public void deleteConsultation(Long id) {
        if (consultationRepository.existsById(id)) {
            consultationRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Consultation not found");
        }
    }
}

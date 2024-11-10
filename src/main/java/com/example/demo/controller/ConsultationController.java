package com.example.demo.controller;

import com.example.demo.model.Consultation;
import com.example.demo.service.ConsultationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/consultations")
public class ConsultationController {
    private ConsultationService consultationService;

    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @PostMapping("/create")
    public Consultation createConsultation(@RequestBody Consultation consultation) {
        return consultationService.createConsultation(consultation);
    }

    @GetMapping("/{id}")
    public Optional<Consultation> getConsultationById(@PathVariable Long id) {
        return consultationService.findConsultationById(id);
    }

    @GetMapping("/getAll")
    public List<Consultation> getAllConsultations() {
        return consultationService.findAllConsultations();
    }

    @PutMapping("/{id}")
    public Consultation updateConsultation(@PathVariable Long id,
                                           @RequestBody Consultation consultationDetails) {
        return consultationService.updateConsultation(id, consultationDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteConsultation(@PathVariable Long id) {
        consultationService.deleteConsultation(id);
    }
}

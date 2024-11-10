package com.example.demo.service;

import com.example.demo.model.RDV;
import com.example.demo.repository.RDVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RDVService {



    private RDVRepository rdvRepository;
    public RDVService(RDVRepository rdvRepository) {
        this.rdvRepository = rdvRepository;
    }

    // Create or update RDV
    public RDV createRDV(RDV rdv) {
        return rdvRepository.save(rdv);
    }

    // Get all RDVs
    public List<RDV> getAllRDVs() {
        return rdvRepository.findAll();
    }

    // Get RDV by ID
    public Optional<RDV> getRDVById(Long id) {
        return rdvRepository.findById(id);
    }

    // Delete RDV by ID
    public void deleteRDV(Long id) {
        rdvRepository.deleteById(id);
    }

    // Update an RDV by ID
    public RDV updateRDV(Long id, String nom, String prenom, String telephone,Date dateRdv, LocalTime heure) {
        return rdvRepository.findById(id).map(rdv -> {
            rdv.setNom(nom);
            rdv.setPrenom(prenom);
            rdv.setTelephone(telephone);
            rdv.setDateRdv(dateRdv);
            rdv.setHeure(heure);
            return rdvRepository.save(rdv);
        }).orElseThrow(() -> new RuntimeException("RDV not found with id " + id));
    }
}

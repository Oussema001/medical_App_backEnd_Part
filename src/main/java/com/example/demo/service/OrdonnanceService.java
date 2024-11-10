package com.example.demo.service;

import com.example.demo.model.Ordonnance;
import com.example.demo.repository.OrdonnanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdonnanceService {

    @Autowired
    private OrdonnanceRepository ordonnanceRepository;

    // Get all Ordonnances
    public List<Ordonnance> getAllOrdonnances() {
        return ordonnanceRepository.findAll();
    }

    // Get Ordonnance by ID
    public Optional<Ordonnance> getOrdonnanceById(Long id) {
        return ordonnanceRepository.findById(id);
    }

    // Create or update Ordonnance
    public Ordonnance createOrUpdateOrdonnance(Ordonnance ordonnance) {
        return ordonnanceRepository.save(ordonnance);
    }

    // Update an existing Ordonnance by ID
    public Ordonnance updateOrdonnance(Long id, Ordonnance updatedOrdonnance) {
        Optional<Ordonnance> existingOrdonnance = ordonnanceRepository.findById(id);

        if (existingOrdonnance.isPresent()) {
            Ordonnance ordonnance = existingOrdonnance.get();
            ordonnance.setDate(updatedOrdonnance.getDate());
            return ordonnanceRepository.save(ordonnance);
        } else {
            return null;
        }
    }

    // Delete an Ordonnance
    public void deleteOrdonnance(Long id) {
        ordonnanceRepository.deleteById(id);
    }
}

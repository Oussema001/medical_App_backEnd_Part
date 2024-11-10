package com.example.demo.service;

import com.example.demo.model.Medicament;
import com.example.demo.repository.MedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentService {

    @Autowired
    private MedicamentRepository medicamentRepository;

    // Get all medicaments
    public List<Medicament> getAllMedicaments() {
        return medicamentRepository.findAll();
    }

    // Get medicament by ID
    public Optional<Medicament> getMedicamentById(Long id) {
        return medicamentRepository.findById(id);
    }

    // Create or update medicament
    public Medicament createOrUpdateMedicament(Medicament medicament) {
        return medicamentRepository.save(medicament);
    }

    // Update medicament by ID
    public Medicament updateMedicament(Long id, Medicament updatedMedicament) {
        Optional<Medicament> existingMedicament = medicamentRepository.findById(id);

        if (existingMedicament.isPresent()) {
            Medicament medicament = existingMedicament.get();
            medicament.setNom(updatedMedicament.getNom());
            medicament.setDosage(updatedMedicament.getDosage());
            medicament.setNb_unite(updatedMedicament.getNb_unite());
            return medicamentRepository.save(medicament);
        } else {
            return null;
        }
    }

    // Delete medicament by ID
    public void deleteMedicament(Long id) {
        medicamentRepository.deleteById(id);
    }
}

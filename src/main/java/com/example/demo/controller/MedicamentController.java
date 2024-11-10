package com.example.demo.controller;

import com.example.demo.model.Medicament;
import com.example.demo.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicaments")
public class MedicamentController {

    @Autowired
    private MedicamentService medicamentService;

    // Get all medicaments
    @GetMapping("/getAll")
    public List<Medicament> getAllMedicaments() {
        return medicamentService.getAllMedicaments();
    }

    // Get medicament by ID
    @GetMapping("/{id}")
    public ResponseEntity<Medicament> getMedicamentById(@PathVariable Long id) {
        Optional<Medicament> medicament = medicamentService.getMedicamentById(id);
        return medicament.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create or update medicament
    @PostMapping("/createOrUpdate")
    public ResponseEntity<Medicament> createOrUpdateMedicament(@RequestBody Medicament medicament) {
        Medicament savedMedicament = medicamentService.createOrUpdateMedicament(medicament);
        return ResponseEntity.ok(savedMedicament);
    }

    // Update medicament by ID
    @PutMapping("/{id}")
    public ResponseEntity<Medicament> updateMedicament(@PathVariable Long id, @RequestBody Medicament updatedMedicament) {
        Medicament medicament = medicamentService.updateMedicament(id, updatedMedicament);
        if (medicament != null) {
            return ResponseEntity.ok(medicament);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete medicament by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicament(@PathVariable Long id) {
        Optional<Medicament> medicament = medicamentService.getMedicamentById(id);
        if (medicament.isPresent()) {
            medicamentService.deleteMedicament(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

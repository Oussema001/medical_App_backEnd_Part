package com.example.demo.controller;

import com.example.demo.model.Ordonnance;
import com.example.demo.service.OrdonnanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ordonnances")
public class OrdonnanceController {

    @Autowired
    private OrdonnanceService ordonnanceService;

    // Get all ordonnances
    @GetMapping("/getAll")
    public List<Ordonnance> getAllOrdonnances() {
        return ordonnanceService.getAllOrdonnances();
    }

    // Get ordonnance by ID
    @GetMapping("/{id}")
    public ResponseEntity<Ordonnance> getOrdonnanceById(@PathVariable Long id) {
        Optional<Ordonnance> ordonnance = ordonnanceService.getOrdonnanceById(id);
        return ordonnance.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create or update ordonnance
    @PostMapping("/createOrUpdate")
    public ResponseEntity<Ordonnance> createOrUpdateOrdonnance(@RequestBody Ordonnance ordonnance) {
        Ordonnance savedOrdonnance = ordonnanceService.createOrUpdateOrdonnance(ordonnance);
        return ResponseEntity.ok(savedOrdonnance);
    }

    // Update ordonnance by ID
    @PutMapping("/{id}")
    public ResponseEntity<Ordonnance> updateOrdonnance(@PathVariable Long id, @RequestBody Ordonnance updatedOrdonnance) {
        Ordonnance ordonnance = ordonnanceService.updateOrdonnance(id, updatedOrdonnance);
        if (ordonnance != null) {
            return ResponseEntity.ok(ordonnance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete ordonnance by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrdonnance(@PathVariable Long id) {
        Optional<Ordonnance> ordonnance = ordonnanceService.getOrdonnanceById(id);
        if (ordonnance.isPresent()) {
            ordonnanceService.deleteOrdonnance(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

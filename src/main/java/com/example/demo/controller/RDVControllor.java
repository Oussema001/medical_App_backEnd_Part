package com.example.demo.controller;

import com.example.demo.model.RDV;
import com.example.demo.service.RDVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/rdvs")
public class RDVControllor {


    private RDVService rdvService;

    public RDVControllor(RDVService rdvService) {
        this.rdvService = rdvService;
    }

    // Create a new RDV
    @PostMapping("/create")
    public RDV createRDV(@RequestBody RDV rdv) {

        return rdvService.createRDV(rdv);
    }

    // Get all RDVs
    @GetMapping("/getAll")
    public List<RDV> getAllRDVs() {
        return rdvService.getAllRDVs();
    }

    // Get RDV by ID
    @GetMapping("/{id}")
    public ResponseEntity<RDV> getRDVById(@PathVariable Long id) {
        Optional<RDV> rdv = rdvService.getRDVById(id);
        return rdv.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update RDV by ID
    @PutMapping("/{id}")
    public ResponseEntity<RDV> updateRDV(@PathVariable Long id, @RequestBody RDV rdv) {
        try {
            RDV updatedRDV = rdvService.updateRDV(id, rdv.getNom(), rdv.getPrenom(), rdv.getTelephone(), rdv.getDateRdv(),rdv.getHeure());
            return ResponseEntity.ok(updatedRDV);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete RDV by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRDV(@PathVariable Long id) {
        rdvService.deleteRDV(id);
        return ResponseEntity.noContent().build();
    }
}

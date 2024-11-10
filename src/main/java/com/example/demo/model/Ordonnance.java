package com.example.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Ordonnance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    @ManyToMany
    @JoinTable(
            name = "ordonnance_medicament", // Nom de la table de jointure
            joinColumns = @JoinColumn(name = "ordonnance_id"), // Clé étrangère pour l'ordonnance
            inverseJoinColumns = @JoinColumn(name = "medicament_id") // Clé étrangère pour le médicament
    )
    private List<Medicament> medicamentList;

    public Ordonnance(Long id, String date, List<Medicament> medicamentList) {
        this.id = id;
        this.date = date;
        this.medicamentList = medicamentList;
    }

    public List<Medicament> getMedicamentList() {
        return medicamentList;
    }

    public void setMedicamentList(List<Medicament> medicamentList) {
        this.medicamentList = medicamentList;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}

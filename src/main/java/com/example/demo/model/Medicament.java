package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String dosage;
    private int nb_unite;

    public Medicament(Long id, String nom, String dosage, int nb_unite) {
        this.id = id;
        this.nom = nom;
        this.dosage = dosage;
        this.nb_unite = nb_unite;
    }

    public Medicament(String nom, String dosage, int nb_unite) {
        this.nom = nom;
        this.dosage = dosage;
        this.nb_unite = nb_unite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public int getNb_unite() {
        return nb_unite;
    }

    public void setNb_unite(int nb_unite) {
        this.nb_unite = nb_unite;
    }
}

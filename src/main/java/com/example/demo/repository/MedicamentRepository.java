package com.example.demo.repository;

import com.example.demo.model.Consultation;
import com.example.demo.model.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentRepository extends JpaRepository<Medicament,Long> {
}

package com.example.demo.repository;

import com.example.demo.model.Patient;
import com.example.demo.model.RDV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RDVRepository extends JpaRepository<RDV,Long>{

}

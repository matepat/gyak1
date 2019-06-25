package com.example.jsf_gy.repositories;

import com.example.jsf_gy.entities.Medicament;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MedicamentRepository extends CrudRepository<Medicament, Long> {
    List<Medicament> findAll();
    Medicament findByName(String name);
}

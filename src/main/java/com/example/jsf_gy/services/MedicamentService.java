package com.example.jsf_gy.services;

import com.example.jsf_gy.entities.Medicament;

import java.util.List;

public interface MedicamentService {
    List<Medicament> listAll();
    Medicament getById(Long id);
    Medicament saveOrUpdate(Medicament medicament);
    void delete(Long id);
    Medicament getByName(String name);
}

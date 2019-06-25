package com.example.jsf_gy.services;

import com.example.jsf_gy.entities.Medicament;
import com.example.jsf_gy.repositories.MedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicamentServiceImpl implements MedicamentService{
    private MedicamentRepository medicamentRepository;
    @Autowired
    public MedicamentServiceImpl(MedicamentRepository medicamentRepository) {this.medicamentRepository=medicamentRepository;}

    @Override
    public List<Medicament> listAll(){
        List<Medicament> medicaments = new ArrayList<>();
        medicamentRepository.findAll().forEach(medicaments::add);
        return medicaments;
    }

    @Override
    public Medicament getById(Long id){
        return medicamentRepository.findOne(id);
    }

    @Override
    public Medicament saveOrUpdate(Medicament medicament){
        medicamentRepository.save(medicament);
        return medicament;
    }

    @Override
    public void delete(Long id){
        medicamentRepository.delete(id);
    }

    @Override
    public Medicament getByName(String name){
        return medicamentRepository.findByName(name);
    }
}

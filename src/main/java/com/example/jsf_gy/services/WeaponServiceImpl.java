package com.example.jsf_gy.services;

import com.example.jsf_gy.entities.Weapon;
import com.example.jsf_gy.repositories.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeaponServiceImpl implements WeaponService{
    private WeaponRepository weaponRepository;
    @Autowired
    public WeaponServiceImpl(WeaponRepository weaponRepository) {this.weaponRepository=weaponRepository;}

    @Override
    public List<Weapon> listAll(){
        List<Weapon> weapons = new ArrayList<>();
        weaponRepository.findAll().forEach(weapons::add);
        return weapons;
    }

    @Override
    public Weapon getById(Long id){
        return weaponRepository.findOne(id);
    }

    @Override
    public Weapon saveOrUpdate(Weapon weapon){
        weaponRepository.save(weapon);
        return weapon;
    }

    @Override
    public void delete(Long id){
        weaponRepository.delete(id);
    }

    @Override
    public Weapon getByName(String name){
        return weaponRepository.findByName(name);
    }

}

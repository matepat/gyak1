package com.example.jsf_gy.services;

import com.example.jsf_gy.entities.Weapon;

import java.util.List;

public interface WeaponService {
    List<Weapon> listAll();
    Weapon getById(Long id);
    Weapon saveOrUpdate(Weapon weapon);
    void delete(Long id);
    Weapon getByName(String name);
}

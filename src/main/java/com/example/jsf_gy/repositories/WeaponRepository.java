package com.example.jsf_gy.repositories;

import com.example.jsf_gy.entities.Weapon;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WeaponRepository extends CrudRepository<Weapon, Long> {
    List<Weapon> findAll();
    Weapon findByName(String name);
}

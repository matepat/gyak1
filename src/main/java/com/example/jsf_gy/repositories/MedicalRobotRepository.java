package com.example.jsf_gy.repositories;

import com.example.jsf_gy.entities.MedicalRobot;
import com.example.jsf_gy.entities.Medicament;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MedicalRobotRepository extends CrudRepository<MedicalRobot, Long> {
    List<MedicalRobot> findAll();
}

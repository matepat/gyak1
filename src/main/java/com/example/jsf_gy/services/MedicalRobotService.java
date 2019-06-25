package com.example.jsf_gy.services;

import com.example.jsf_gy.entities.MedicalRobot;
import com.example.jsf_gy.entities.Medicament;

import java.util.List;

public interface MedicalRobotService {
    List<MedicalRobot> listAll();
    MedicalRobot getById(Long id);
    MedicalRobot saveOrUpdate(MedicalRobot medicalRobot);
    void delete(Long id);
}

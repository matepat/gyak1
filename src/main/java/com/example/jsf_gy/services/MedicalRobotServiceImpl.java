package com.example.jsf_gy.services;

import com.example.jsf_gy.entities.MedicalRobot;
import com.example.jsf_gy.entities.Medicament;
import com.example.jsf_gy.repositories.MedicalRobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalRobotServiceImpl implements MedicalRobotService{
    private MedicalRobotRepository medicalRobotRepository;
    @Autowired
    public MedicalRobotServiceImpl(MedicalRobotRepository medicalRobotRepository) {this.medicalRobotRepository=medicalRobotRepository;}

    @Override
    public List<MedicalRobot> listAll(){
        List<MedicalRobot> medicalRobots = new ArrayList<>();
        medicalRobotRepository.findAll().forEach(medicalRobots::add);
        return medicalRobots;
    }

    @Override
    public MedicalRobot getById(Long id){
        return medicalRobotRepository.findOne(id);
    }

    @Override
    public MedicalRobot saveOrUpdate(MedicalRobot medicalRobot){
        medicalRobotRepository.save(medicalRobot);
        return medicalRobot;
    }

    @Override
    public void delete(Long id){
        medicalRobotRepository.delete(id);
    }
}

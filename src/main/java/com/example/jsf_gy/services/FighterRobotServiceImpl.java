package com.example.jsf_gy.services;

import com.example.jsf_gy.entities.FighterRobot;
import com.example.jsf_gy.repositories.FighterRobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FighterRobotServiceImpl implements FighterRobotService{
    private FighterRobotRepository fighterRobotRepository;
    @Autowired
    public FighterRobotServiceImpl(FighterRobotRepository fighterRobotRepository) {this.fighterRobotRepository=fighterRobotRepository;}

    @Override
    public List<FighterRobot> listAll(){
        List<FighterRobot> fighterRobots = new ArrayList<>();
        fighterRobotRepository.findAll().forEach(fighterRobots::add);
        return fighterRobots;
    }

    @Override
    public FighterRobot getById(Long id){
        return fighterRobotRepository.findOne(id);
    }

    @Override
    public FighterRobot saveOrUpdate(FighterRobot fighterRobot){
        fighterRobotRepository.save(fighterRobot);
        return fighterRobot;
    }

    @Override
    public void delete(Long id){
        fighterRobotRepository.delete(id);
    }
}

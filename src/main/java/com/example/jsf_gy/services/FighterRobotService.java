package com.example.jsf_gy.services;

import com.example.jsf_gy.entities.FighterRobot;

import java.util.List;

public interface FighterRobotService {
    List<FighterRobot> listAll();
    FighterRobot getById(Long id);
    FighterRobot saveOrUpdate(FighterRobot fighterRobot);
    void delete(Long id);
}

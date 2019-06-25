package com.example.jsf_gy.repositories;

import com.example.jsf_gy.entities.FighterRobot;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FighterRobotRepository extends CrudRepository<FighterRobot, Long> {
    List<FighterRobot> findAll();
}

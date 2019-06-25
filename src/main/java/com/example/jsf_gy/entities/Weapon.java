package com.example.jsf_gy.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Weapon extends AbstractEntity{
    @OneToMany(mappedBy = "weapon")
    private List<FighterRobot> fighterRobots;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.getName().equals(((Weapon) obj).getName());
    }
}

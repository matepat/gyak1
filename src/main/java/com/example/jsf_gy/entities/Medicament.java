package com.example.jsf_gy.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
public class Medicament extends AbstractEntity{
    @OneToMany(mappedBy = "medicament")
    private List<MedicalRobot> medicalRobots;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.getName().equals(((Medicament) obj).getName());
    }
}

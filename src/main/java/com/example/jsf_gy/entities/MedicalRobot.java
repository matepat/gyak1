package com.example.jsf_gy.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table
public class MedicalRobot extends AbstractEntity {
    @NotNull(message = "{medicament.not.null}")
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="medicament_id")
    private Medicament medicament;

    public MedicalRobot() {
    }

    public MedicalRobot(String name, Date createdDate, Date lastModifiedDate, Medicament medicament) {
        super(name, createdDate, lastModifiedDate);
        this.medicament = medicament;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }
}

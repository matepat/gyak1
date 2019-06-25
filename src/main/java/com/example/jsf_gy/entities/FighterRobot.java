package com.example.jsf_gy.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class FighterRobot extends AbstractEntity{
    @NotNull(message = "{weapon.not.null}")
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="weapon_id")
    private Weapon weapon;

    public FighterRobot() {
    }

    public FighterRobot(String name, Date createdDate, Date lastModifiedDate, Weapon weapon) {
        super(name, createdDate, lastModifiedDate);
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}

package com.example.jsf_gy.mbean;

import com.example.jsf_gy.entities.FighterRobot;
import com.example.jsf_gy.entities.Weapon;
import com.example.jsf_gy.services.FighterRobotService;
import com.example.jsf_gy.services.MedicalRobotService;
import com.example.jsf_gy.services.MedicamentService;
import com.example.jsf_gy.services.WeaponService;
import lombok.Data;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Data
@ViewScoped
@ManagedBean(name="fighterRobotManagerView")
public class fighterRobotManagerMBean {
    @ManagedProperty("#{fighterRobotServiceImpl}")
    private FighterRobotService fighterRobotService;
    @ManagedProperty("#{medicalRobotServiceImpl}")
    private MedicalRobotService medicalRobotService;
    @ManagedProperty("#{medicamentServiceImpl}")
    private MedicamentService medicamentService;
    @ManagedProperty("#{weaponServiceImpl}")
    private WeaponService weaponService;

    private FighterRobot selectedRobot = new FighterRobot();
    private List<Weapon> weapons;

    @PostConstruct
    public void init(){
        weapons = weaponService.listAll();
    }

    public void save(){
        selectedRobot.setCreatedDate(new Date());
        selectedRobot.setLastModifiedDate(new Date());
        fighterRobotService.saveOrUpdate(selectedRobot);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Flash flash = facesContext.getExternalContext().getFlash();
        flash.setKeepMessages(true);
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sikeres adat mentés!", selectedRobot.getName() + " sikeresen elmentve"));
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/?faces-redirect=true");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadAll(){

    }
}

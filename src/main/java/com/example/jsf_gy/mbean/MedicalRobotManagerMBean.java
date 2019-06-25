package com.example.jsf_gy.mbean;

import com.example.jsf_gy.entities.MedicalRobot;
import com.example.jsf_gy.entities.Medicament;
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
@ManagedBean(name="medicalRobotManagerView")
public class MedicalRobotManagerMBean {
    @ManagedProperty("#{fighterRobotServiceImpl}")
    private FighterRobotService fighterRobotService;
    @ManagedProperty("#{medicalRobotServiceImpl}")
    private MedicalRobotService medicalRobotService;
    @ManagedProperty("#{medicamentServiceImpl}")
    private MedicamentService medicamentService;
    @ManagedProperty("#{weaponServiceImpl}")
    private WeaponService weaponService;

    private MedicalRobot selectedMedicalRobot = new MedicalRobot();
    private List<Medicament> medicaments;

    @PostConstruct
    public void init(){
        medicaments = medicamentService.listAll();
    }

    public void save(){
        selectedMedicalRobot.setCreatedDate(new Date());
        selectedMedicalRobot.setLastModifiedDate(new Date());
        medicalRobotService.saveOrUpdate(selectedMedicalRobot);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Flash flash = facesContext.getExternalContext().getFlash();
        flash.setKeepMessages(true);
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sikeres adat mentés!", selectedMedicalRobot.getName() + " sikeresen elmentve"));
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/?faces-redirect=true");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadAll(){

    }
}

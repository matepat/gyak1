package com.example.jsf_gy.mbean;

import com.example.jsf_gy.entities.Medicament;
import com.example.jsf_gy.services.FighterRobotService;
import com.example.jsf_gy.services.MedicalRobotService;
import com.example.jsf_gy.services.MedicamentService;
import com.example.jsf_gy.services.WeaponService;
import lombok.Data;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import java.io.IOException;
import java.util.Date;

@Data
@ViewScoped
@ManagedBean(name="medicamentManagerView")
public class MedicamentManagerMBean {
    @ManagedProperty("#{fighterRobotServiceImpl}")
    private FighterRobotService fighterRobotService;
    @ManagedProperty("#{medicalRobotServiceImpl}")
    private MedicalRobotService medicalRobotService;
    @ManagedProperty("#{medicamentServiceImpl}")
    private MedicamentService medicamentService;
    @ManagedProperty("#{weaponServiceImpl}")
    private WeaponService weaponService;

    Medicament selectedMedicament = new Medicament();

    public void save(){
        selectedMedicament.setCreatedDate(new Date());
        selectedMedicament.setLastModifiedDate(new Date());
        medicamentService.saveOrUpdate(selectedMedicament);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Flash flash = facesContext.getExternalContext().getFlash();
        flash.setKeepMessages(true);
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sikeres adat mentés!", selectedMedicament.getName() + " sikeresen elmentve"));
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/?faces-redirect=true");
        } catch (IOException e) {
            e.printStackTrace();
        }
        selectedMedicament = new Medicament();
    }

    public void loadAll(){

    }
}

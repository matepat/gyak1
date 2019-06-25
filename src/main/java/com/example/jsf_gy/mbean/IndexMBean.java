package com.example.jsf_gy.mbean;

import com.example.jsf_gy.entities.FighterRobot;
import com.example.jsf_gy.entities.MedicalRobot;
import com.example.jsf_gy.entities.Medicament;
import com.example.jsf_gy.entities.Weapon;
import com.example.jsf_gy.services.FighterRobotService;
import com.example.jsf_gy.services.MedicalRobotService;
import com.example.jsf_gy.services.MedicamentService;
import com.example.jsf_gy.services.WeaponService;
import lombok.Data;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.List;

@Data
@ViewScoped
@ManagedBean(name="indexView")
public class IndexMBean {
    @ManagedProperty("#{fighterRobotServiceImpl}")
    private FighterRobotService fighterRobotService;
    @ManagedProperty("#{medicalRobotServiceImpl}")
    private MedicalRobotService medicalRobotService;
    @ManagedProperty("#{medicamentServiceImpl}")
    private MedicamentService medicamentService;
    @ManagedProperty("#{weaponServiceImpl}")
    private WeaponService weaponService;

    private List<FighterRobot> fighterRobots;
    private List<MedicalRobot> medicalRobots;
    private List<Medicament> medicaments;
    private List<Weapon> weapons;

    @PostConstruct
    private void init(){
        loadAll();
    }

    public void onFighterRobotRowEdit(RowEditEvent event){
        FighterRobot updatedFighterRobot = (FighterRobot) event.getObject();
        FighterRobot oldFighterRobot = fighterRobotService.getById(updatedFighterRobot.getId());

        if(updatedFighterRobot.getName() != null && !updatedFighterRobot.equals(oldFighterRobot)) {
            updatedFighterRobot.setLastModifiedDate(new Date());
            fighterRobotService.saveOrUpdate(updatedFighterRobot);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sikeres szerkesztés!", updatedFighterRobot.getName());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void onMedicalRobotRowEdit(RowEditEvent event){
        MedicalRobot updatedMedicalRobot = (MedicalRobot) event.getObject();
        MedicalRobot oldMedicalRobot = medicalRobotService.getById(updatedMedicalRobot.getId());

        if(updatedMedicalRobot.getName() != null && !updatedMedicalRobot.equals(oldMedicalRobot)) {
            updatedMedicalRobot.setLastModifiedDate(new Date());
            medicalRobotService.saveOrUpdate(updatedMedicalRobot);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sikeres szerkesztés!", updatedMedicalRobot.getName());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void onMedicamentnRowEdit(RowEditEvent event){
        Medicament updatedMedicament = (Medicament) event.getObject();
        Medicament oldMedicament = medicamentService.getById(updatedMedicament.getId());

        if(updatedMedicament.getName() != null && !updatedMedicament.equals(oldMedicament)) {
            updatedMedicament.setLastModifiedDate(new Date());
            medicamentService.saveOrUpdate(updatedMedicament);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sikeres szerkesztés!", updatedMedicament.getName());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void onWeaponRowEdit(RowEditEvent event){
        Weapon updatedWeapon = (Weapon) event.getObject();
        Weapon oldWeapon = weaponService.getById(updatedWeapon.getId());

        if(updatedWeapon.getName() != null && !updatedWeapon.equals(oldWeapon)) {
            updatedWeapon.setLastModifiedDate(new Date());
            weaponService.saveOrUpdate(updatedWeapon);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sikeres szerkesztés!", updatedWeapon.getName());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void onRowCancel(RowEditEvent event){
        FacesMessage msg = new FacesMessage("Szerkesztés megszakítva", null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteFighterRobot(Long id){
        fighterRobotService.delete(id);
        loadAll();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sikeres törlés!", null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteMedicalRobot(Long id){
        medicalRobotService.delete(id);
        loadAll();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sikeres törlés!", null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteMedicament(Long id){
        medicamentService.delete(id);
        loadAll();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sikeres törlés!", null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteWeapon(Long id){
        weaponService.delete(id);
        loadAll();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sikeres törlés!", null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    private void loadAll(){
        fighterRobots = fighterRobotService.listAll();
        medicalRobots = medicalRobotService.listAll();
        medicaments = medicamentService.listAll();
        weapons = weaponService.listAll();
    }
}

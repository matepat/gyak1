package com.example.jsf_gy.converter;

import com.example.jsf_gy.entities.Weapon;
import com.example.jsf_gy.services.WeaponService;
import lombok.Data;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ApplicationScope
@ManagedBean
@Data
public class WeaponConverter implements Converter {
    @ManagedProperty("#{weaponServiceImpl}")
    private WeaponService weaponService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null) {
            return null;
        }
        try {
            return weaponService.getByName(s);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {

        if (o == null) {
            return "";
        }
        return ((Weapon) o).getName();
    }
}

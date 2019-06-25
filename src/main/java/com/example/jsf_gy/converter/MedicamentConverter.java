package com.example.jsf_gy.converter;

import com.example.jsf_gy.entities.Medicament;
import com.example.jsf_gy.services.MedicamentService;
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
public class MedicamentConverter implements Converter {

    @ManagedProperty("#{medicamentServiceImpl}")
    private MedicamentService medicamentService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null) {
            return null;
        }
        try {
            return medicamentService.getByName(s);
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
        return ((Medicament) o).getName();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsfspring.kerdoiv.mbean;

import com.jsfspring.kerdoiv.dto.KerdesDto;
import com.jsfspring.kerdoiv.dto.KerdoivDto;
import com.jsfspring.kerdoiv.service.KerdoivService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.SessionScope;

/**
 *
 * @author zsombor2
 */

@Controller("kerdoivController")
@SessionScope
public class KerdoivController {
    
    
    @Autowired
    private KerdoivService kerdoivService;

    private List<KerdoivDto> kerdoivLista;
    
    private KerdoivDto kivalasztottKerdoiv;
    
    private KerdesDto kivalasztottKerdes;

    public KerdesDto getKivalasztottKerdes() {
        return kivalasztottKerdes;
    }

    public void setKivalasztottKerdes(KerdesDto kivalasztottKerdes) {
        this.kivalasztottKerdes = kivalasztottKerdes;
    }

    public List<KerdesDto> getKerdesLista() {
        if (kivalasztottKerdoiv != null) {
            return kivalasztottKerdoiv.getKerdesek();
        } else {
            return Collections.EMPTY_LIST;
        }
    }



    @PostConstruct
    public void getAllKerdoiv() {
        kerdoivLista = new ArrayList<>();
        if (!this.getKerdoivLista().isEmpty()) {
            this.getKerdoivLista().clear();
        }
        this.getKerdoivLista().addAll(kerdoivService.getAllKerdoiv());
    }


    public List<KerdoivDto> getKerdoivLista() {
        if (kerdoivLista == null) {
            kerdoivLista = new ArrayList<>();
        }
        return kerdoivLista;
    }

    public void setKerdoivLista(List<KerdoivDto> kerdoivLista) {
        this.kerdoivLista = kerdoivLista;
    }
    
    public KerdoivDto getKivalasztottKerdoiv() {
        return kivalasztottKerdoiv;
    }

    public void setKivalasztottKerdoiv(KerdoivDto kivalasztottKerdoiv) {
        this.kivalasztottKerdoiv = kivalasztottKerdoiv;
        this.kivalasztottKerdes = null;
    }
    
    public void onRowSelect(SelectEvent event) {
//        FacesMessage msg = new FacesMessage("Kerdoiv Selected", String.valueOf(event.getObject()));
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowUnselect(UnselectEvent event) {
//        FacesMessage msg = new FacesMessage("Product Unselected", String.valueOf(event.getObject()));
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    @Transactional
    public void onRowEdit(RowEditEvent event) {
        KerdoivDto k = (KerdoivDto) event.getObject();
        k = kerdoivService.saveKerdoiv(k);
        updateLista(k);
        FacesMessage msg = new FacesMessage("Kérdőív szerkesztve", String.valueOf(k.getTitle()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    @Transactional
    public void onKerdesRowEdit(RowEditEvent event){
        KerdesDto k = (KerdesDto) event.getObject();
        int kerdesIndex = kivalasztottKerdoiv.getKerdesek().indexOf(kivalasztottKerdes);
        kivalasztottKerdoiv.getKerdesek().set(kerdesIndex, k);
        kivalasztottKerdoiv = kerdoivService.saveKerdoiv(kivalasztottKerdoiv);
        updateLista(kivalasztottKerdoiv);
    }
    
    public void updateLista(KerdoivDto k){
        int idx = kerdoivLista.indexOf(k);
        if (idx >= 0) {
            kerdoivLista.set(idx, k);
        }
    }
    
    @Transactional
    public void ujKerdoiv() {
        KerdoivDto k = new KerdoivDto();
        k.setTitle("Kérdőív");
        k.setKerdesek(new ArrayList<>());
        k = kerdoivService.saveKerdoiv(k);
        kerdoivLista.add(k);
    }
    
    @Transactional
    public void deleteKerdoiv() {
        if(kivalasztottKerdoiv != null){
            KerdoivDto k = kivalasztottKerdoiv;
            kerdoivService.deleteKerdoiv(k);
            kerdoivLista.remove(k);
            kivalasztottKerdoiv = null;
        }
    }
    
    public boolean isKerdoivTorlesDisabled(){
        return kivalasztottKerdoiv == null;
    }
    
    public boolean isKerdesTorlesDisabled(){
        return kivalasztottKerdes == null;
    }
    
    @Transactional
    public void ujKerdes() {
        KerdesDto k = new KerdesDto();
        k.setKerdesSzoveg("Új kérdés");
        k.setKerdoiv(kivalasztottKerdoiv);
        kivalasztottKerdoiv.addKerdes(k);
        kivalasztottKerdoiv = kerdoivService.saveKerdoiv(kivalasztottKerdoiv);
        updateLista(kivalasztottKerdoiv);
    }
    
    @Transactional
    public void deleteKerdes() {
        if(kivalasztottKerdes != null){
            KerdesDto k = kivalasztottKerdes;
            kivalasztottKerdoiv.removeKerdes(k);
            kivalasztottKerdoiv = kerdoivService.saveKerdoiv(kivalasztottKerdoiv);
            updateLista(kivalasztottKerdoiv);
            kivalasztottKerdes = null;
        }
    }
    

}

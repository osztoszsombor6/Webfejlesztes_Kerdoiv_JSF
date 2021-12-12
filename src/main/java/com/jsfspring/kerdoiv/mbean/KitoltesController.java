/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsfspring.kerdoiv.mbean;

import com.jsfspring.kerdoiv.dto.KerdoivDto;
import com.jsfspring.kerdoiv.dto.KitoltesDto;
import com.jsfspring.kerdoiv.dto.ValaszDto;
import com.jsfspring.kerdoiv.service.KitoltesService;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.SessionScope;

/**
 *
 * @author zsombor2
 */

@Controller("kitoltesController")
@SessionScope
public class KitoltesController {
    
    @Autowired
    private KitoltesService kitoltesService;

    private List<KitoltesDto> kitoltesLista;
    
    private KerdoivDto kitoltendoKerdoiv;
    
    private KitoltesDto kivalasztottKitoltes;
    
    private String[] valaszok;
    
    @PostConstruct
    public void getAllKitoltes() {
        kitoltesLista = new ArrayList<>();
        if (!this.getKitoltesLista().isEmpty()) {
            this.getKitoltesLista().clear();
        }
        this.getKitoltesLista().addAll(kitoltesService.getAllKitoltes());
    }
    
    public List<KitoltesDto> getKitoltesLista() {
        if (kitoltesLista == null) {
            kitoltesLista = new ArrayList<>();
        }
        return kitoltesLista;
    }

    public void setKitoltesLista(List<KitoltesDto> kl) {
        this.kitoltesLista = kl;
    }

    public KerdoivDto getKitoltendoKerdoiv() {
        return kitoltendoKerdoiv;
    }

    public void setKitoltendoKerdoiv(KerdoivDto kitoltendoKerdoiv) {
        this.kitoltendoKerdoiv = kitoltendoKerdoiv;
        valaszok = new String[kitoltendoKerdoiv.getKerdesek().size()];
    }
    
    public KitoltesDto getKivalasztottKitoltes() {
        return kivalasztottKitoltes;
    }

    public void setKivalasztottKitoltes(KitoltesDto kivalasztottKitoltes) {
        this.kivalasztottKitoltes = kivalasztottKitoltes;
    }

    public String[] getValaszok() {
        return valaszok;
    }

//    public void setValaszok(String[] valaszok) {
//        this.valaszok = valaszok;
//    }
    
    @Transactional
    public void valaszokMentese() throws IOException {
        
        int idx = 0;
        KitoltesDto kitolt = new KitoltesDto();
        kitolt.setKerdoiv(kitoltendoKerdoiv);
        kitolt.setKitoltesDatum(LocalDateTime.now());
        
        for (String s: valaszok) {
            ValaszDto v = new ValaszDto();
            v.setValaszSzoveg(s);
            v.setKitoltes(kitolt);
            v.setKerdes(kitoltendoKerdoiv.getKerdesek().get(idx));
            kitolt.addValasz(v);
            ++idx;
        }
        
        kitolt = kitoltesService.saveKitoltes(kitolt);
        kitoltesLista.add(kitolt);
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
    }
    
}

package com.jsfspring.kerdoiv.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class KitoltesDto {
    
    private Long id;

    private KerdoivDto kerdoivDto;

    private List<ValaszDto> valaszok;

    private LocalDateTime kitoltesDatum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KerdoivDto getKerdoiv() {
        return kerdoivDto;
    }


    public void setKerdoiv(KerdoivDto kerdoivDto) {
        this.kerdoivDto = kerdoivDto;
    }

    public List<ValaszDto> getValaszok() {
            if (null == valaszok) {
                    valaszok = new ArrayList<>();
            }
            return valaszok;
    }

    public void setValaszok(List<ValaszDto> valaszok) {
        this.valaszok = valaszok;
    }

    public LocalDateTime getKitoltesDatum() {
        return kitoltesDatum;
    }

    public void setKitoltesDatum(LocalDateTime kitoltesDatum) {
        this.kitoltesDatum = kitoltesDatum;
    }

    public void addValasz(ValaszDto valasz){
        getValaszok().add(valasz);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.kerdoivDto);
        hash = 97 * hash + Objects.hashCode(this.kitoltesDatum);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KitoltesDto other = (KitoltesDto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.kerdoivDto, other.kerdoivDto)) {
            return false;
        }
        if (!Objects.equals(this.kitoltesDatum, other.kitoltesDatum)) {
            return false;
        }
        return true;
    }
    
    
}

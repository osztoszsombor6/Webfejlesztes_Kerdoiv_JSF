package com.jsfspring.kerdoiv.dto;

import java.util.Objects;



public class KerdesDto {
    
    private Long id;

    private String kerdesSzoveg;

    private KerdoivDto kerdoivDto;

    public Long getId() {
        return id;
    }

    public void setId(Long kerdesId) {
        this.id = kerdesId;
    }

    public String getKerdesSzoveg() {
        return kerdesSzoveg;
    }

    public void setKerdesSzoveg(String kerdesSzoveg) {
        this.kerdesSzoveg = kerdesSzoveg;
    }

    public KerdoivDto getKerdoiv() {
        return kerdoivDto;
    }

    public void setKerdoiv(KerdoivDto kerdoivDto) {
        this.kerdoivDto = kerdoivDto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.kerdesSzoveg);
        hash = 37 * hash + Objects.hashCode(this.kerdoivDto);
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
        final KerdesDto other = (KerdesDto) obj;
        if (!Objects.equals(this.kerdesSzoveg, other.kerdesSzoveg)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.kerdoivDto, other.kerdoivDto)) {
            return false;
        }
        return true;
    }
        
        
}

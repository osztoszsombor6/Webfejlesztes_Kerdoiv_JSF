package com.jsfspring.kerdoiv.dto;

import java.util.Objects;



public class ValaszDto {
    
        private Long id;

        private String valaszSzoveg;

        private KitoltesDto kitoltesDto;
        
        private KerdesDto kerdesDto;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getValaszSzoveg() {
            return valaszSzoveg;
        }

        public void setValaszSzoveg(String valaszSzoveg) {
            this.valaszSzoveg = valaszSzoveg;
        }

        public KitoltesDto getKitoltes() {
            return kitoltesDto;
        }

        public void setKitoltes(KitoltesDto kitoltesDto) {
            this.kitoltesDto = kitoltesDto;
        }

        public KerdesDto getKerdes() {
            return kerdesDto;
        }

        public void setKerdes(KerdesDto kerdesDto) {
            this.kerdesDto = kerdesDto;
        }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.valaszSzoveg);
        hash = 59 * hash + Objects.hashCode(this.kitoltesDto);
        hash = 59 * hash + Objects.hashCode(this.kerdesDto);
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
        final ValaszDto other = (ValaszDto) obj;
        if (!Objects.equals(this.valaszSzoveg, other.valaszSzoveg)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.kitoltesDto, other.kitoltesDto)) {
            return false;
        }
        if (!Objects.equals(this.kerdesDto, other.kerdesDto)) {
            return false;
        }
        return true;
    }
        
        
}

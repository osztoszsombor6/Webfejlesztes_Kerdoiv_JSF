package com.jsfspring.kerdoiv.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class KerdoivDto {
    
    private Long id;

    private String title;

    private List<KerdesDto> kerdesek;


    public Long getId() {
            return id;
    }

    public void setId(Long Id) {
            this.id = Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<KerdesDto> getKerdesek() {
        if (null == kerdesek) {
                    kerdesek = new ArrayList<>();
            }
            return kerdesek;
    }

    public void addKerdes(KerdesDto kerdes){
        getKerdesek().add(kerdes);
    }

    public void removeKerdes(KerdesDto kerdes){
        getKerdesek().remove(kerdes);
    }

    public void setKerdesek(List<KerdesDto> kerdesek) {
        this.kerdesek = kerdesek;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.title);
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
        final KerdoivDto other = (KerdoivDto) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
        
        
}

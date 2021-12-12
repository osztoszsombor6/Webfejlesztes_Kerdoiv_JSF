/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsfspring.kerdoiv.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

/**
 *
 * @author zsombor2
 */

@Entity
@Table(name = "KERDOIV")
public class Kerdoiv implements Serializable {

    
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;

	@OneToMany(mappedBy = "kerdoiv", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Kerdes> kerdesek;
        

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

        public List<Kerdes> getKerdesek() {
            if (null == kerdesek) {
			kerdesek = new ArrayList<>();
		}
		return kerdesek;
        }
        
        public void addKerdes(Kerdes kerdes){
            getKerdesek().add(kerdes);
        }
        
        public void removeKerdes(Kerdes kerdes){
            getKerdesek().remove(kerdes);
        }

        public void setKerdesek(List<Kerdes> kerdesek) {
            this.kerdesek = kerdesek;
        }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Kerdoiv other = (Kerdoiv) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
        

}

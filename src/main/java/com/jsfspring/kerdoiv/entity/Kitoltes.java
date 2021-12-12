/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsfspring.kerdoiv.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
/**
 *
 * @author zsombor2
 */
@Entity
@Table(name = "KITOLTES")
public class Kitoltes implements Serializable {
    
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @ManyToOne
        private Kerdoiv kerdoiv;
        
        @LazyCollection(LazyCollectionOption.FALSE)
        @OneToMany(mappedBy = "kitoltes", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Valasz> valaszok;
        
        @Column(nullable = false, columnDefinition = "TIMESTAMP")
        private LocalDateTime kitoltesDatum;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Kerdoiv getKerdoiv() {
            return kerdoiv;
        }
        

        public void setKerdoiv(Kerdoiv kerdoiv) {
            this.kerdoiv = kerdoiv;
        }

        public List<Valasz> getValaszok() {
                if (null == valaszok) {
			valaszok = new ArrayList<>();
		}
		return valaszok;
        }

        public void setValaszok(List<Valasz> valaszok) {
            this.valaszok = valaszok;
        }

        public LocalDateTime getKitoltesDatum() {
            return kitoltesDatum;
        }

        public void setKitoltesDatum(LocalDateTime kitoltesDatum) {
            this.kitoltesDatum = kitoltesDatum;
        }
        
        public void addValasz(Valasz valasz){
            getValaszok().add(valasz);
        }
    
        
}

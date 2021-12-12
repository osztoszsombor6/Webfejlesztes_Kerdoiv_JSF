/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsfspring.kerdoiv.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
/**
 *
 * @author zsombor2
 */

@Entity
@Table(name = "VALASZ")
public class Valasz implements Serializable {
    
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String valaszSzoveg;

        @ManyToOne
        private Kitoltes kitoltes;
        
        @ManyToOne
        private Kerdes kerdes;

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

        public Kitoltes getKitoltes() {
            return kitoltes;
        }

        public void setKitoltes(Kitoltes kitoltes) {
            this.kitoltes = kitoltes;
        }

        public Kerdes getKerdes() {
            return kerdes;
        }

        public void setKerdes(Kerdes kerdes) {
            this.kerdes = kerdes;
        }
        
        
}

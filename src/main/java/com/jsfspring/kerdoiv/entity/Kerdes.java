/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsfspring.kerdoiv.entity;

import java.io.Serializable;

import javax.persistence.Column;
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
@Table(name = "KERDES")
public class Kerdes implements Serializable {
    
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @Column(nullable = false)
        private String kerdesSzoveg;

        @ManyToOne
        private Kerdoiv kerdoiv;
        
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

        public Kerdoiv getKerdoiv() {
            return kerdoiv;
        }

        public void setKerdoiv(Kerdoiv kerdoiv) {
            this.kerdoiv = kerdoiv;
        }
   
}

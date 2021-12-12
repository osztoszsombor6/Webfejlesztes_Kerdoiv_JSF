/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsfspring.kerdoiv.repositry;

import com.jsfspring.kerdoiv.entity.Kitoltes;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author zsombor2
 */
public interface KitoltesRepo extends JpaRepository<Kitoltes, Long>{
    
}

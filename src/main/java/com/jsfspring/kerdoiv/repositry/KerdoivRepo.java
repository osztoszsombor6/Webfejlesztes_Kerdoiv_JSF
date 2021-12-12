/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsfspring.kerdoiv.repositry;

import com.jsfspring.kerdoiv.entity.Kerdoiv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zsombor2
 */
@Repository
public interface KerdoivRepo extends JpaRepository<Kerdoiv, Long> {
    
}

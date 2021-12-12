/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsfspring.kerdoiv.service;

import com.jsfspring.kerdoiv.dto.KerdesDto;
import com.jsfspring.kerdoiv.dto.KerdoivDto;
import com.jsfspring.kerdoiv.entity.Kerdes;
import com.jsfspring.kerdoiv.entity.Kerdoiv;
import java.util.List;

/**
 *
 * @author zsombor2
 */
public interface KerdoivService {
    
    List<KerdoivDto> getAllKerdoiv(); 
    
    KerdoivDto saveKerdoiv(KerdoivDto kerdoivDto);
    
    void deleteKerdoiv(KerdoivDto kerdoivDto);
    
    KerdoivDto convertKerdoivToDto(Kerdoiv kerdoiv);
    
    Kerdoiv convertDtoToKerdoiv(KerdoivDto kerdoivDto);
    
    KerdesDto convertKerdesToDto(Kerdes kerdes);
    
    Kerdes convertDtoToKerdes(KerdesDto kerdesDto);
}

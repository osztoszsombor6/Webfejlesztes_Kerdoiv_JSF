package com.jsfspring.kerdoiv.service;

import com.jsfspring.kerdoiv.dto.KitoltesDto;
import java.util.List;



public interface KitoltesService {
    List<KitoltesDto> getAllKitoltes();
    
    KitoltesDto saveKitoltes(KitoltesDto kitoltesDto);
}

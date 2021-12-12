/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsfspring.kerdoiv.service.impl;

import com.jsfspring.kerdoiv.dto.KitoltesDto;
import com.jsfspring.kerdoiv.dto.ValaszDto;
import com.jsfspring.kerdoiv.entity.Kitoltes;
import com.jsfspring.kerdoiv.entity.Valasz;
import com.jsfspring.kerdoiv.repositry.KitoltesRepo;
import com.jsfspring.kerdoiv.service.KerdoivService;
import com.jsfspring.kerdoiv.service.KitoltesService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author zsombor2
 */

@Service
@Transactional
public class KitoltesServiceImpl implements KitoltesService{
    
    @Autowired
    private KitoltesRepo kitoltesRepo;
    
    @Autowired
    private KerdoivService kerdoivService;

    @Override
    public List<KitoltesDto> getAllKitoltes() {
        List<Kitoltes> kitoltesLista = kitoltesRepo.findAll();
        List<KitoltesDto> kitoltesDtoLista = new ArrayList<>();
        for(Kitoltes kitoltes : kitoltesLista){
            KitoltesDto dto = convertKitoltesToDto(kitoltes);
            kitoltesDtoLista.add(dto);
        }
        return kitoltesDtoLista;
    }

    @Override
    public KitoltesDto saveKitoltes(KitoltesDto kitoltesDto) {
        Kitoltes kitoltes = convertDtoToKitoltes(kitoltesDto);
        Kitoltes k = kitoltesRepo.save(kitoltes);
        KitoltesDto dto = convertKitoltesToDto(k);
        return dto;
    }
    
    private KitoltesDto convertKitoltesToDto(Kitoltes kitoltes) {
        KitoltesDto dto = new KitoltesDto();
        dto.setId(kitoltes.getId());
        dto.setKitoltesDatum(kitoltes.getKitoltesDatum());
        dto.setKerdoiv(kerdoivService.convertKerdoivToDto(kitoltes.getKerdoiv()));
        
        List<ValaszDto> valaszok = new ArrayList<>();
        for(Valasz valasz : kitoltes.getValaszok()){
            ValaszDto valaszDto = convertValaszToDto(valasz);
            valaszDto.setKitoltes(dto);
            valaszok.add(valaszDto);
        }
        
        dto.setValaszok(valaszok);
        return dto;
    }
    
    private Kitoltes convertDtoToKitoltes(KitoltesDto kitoltesDto) {
        Kitoltes kitoltes = new Kitoltes();
        kitoltes.setId(kitoltesDto.getId());
        kitoltes.setKitoltesDatum(kitoltesDto.getKitoltesDatum());
        kitoltes.setKerdoiv(kerdoivService.convertDtoToKerdoiv(kitoltesDto.getKerdoiv()));
        
        List<Valasz> valaszok = new ArrayList<>();
        for(ValaszDto valaszDto : kitoltesDto.getValaszok()){
            Valasz valasz = convertDtoToValasz(valaszDto);
            valasz.setKitoltes(kitoltes);
            valaszok.add(valasz);
        }
        
        kitoltes.setValaszok(valaszok);
        return kitoltes;
    }
    
    private ValaszDto convertValaszToDto(Valasz valasz) {
        ValaszDto dto = new ValaszDto();
        dto.setId(valasz.getId());
        dto.setValaszSzoveg(valasz.getValaszSzoveg());
        dto.setKerdes(kerdoivService.convertKerdesToDto(valasz.getKerdes()));
        return dto;
    }
    
    private Valasz convertDtoToValasz(ValaszDto valaszDto) {
        Valasz valasz = new Valasz();
        valasz.setId(valaszDto.getId());
        valasz.setValaszSzoveg(valaszDto.getValaszSzoveg());
        valasz.setKerdes(kerdoivService.convertDtoToKerdes(valaszDto.getKerdes()));
        return valasz;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsfspring.kerdoiv.service.impl;

import com.jsfspring.kerdoiv.dto.KerdesDto;
import com.jsfspring.kerdoiv.dto.KerdoivDto;
import com.jsfspring.kerdoiv.entity.Kerdes;
import com.jsfspring.kerdoiv.entity.Kerdoiv;
import com.jsfspring.kerdoiv.repositry.KerdoivRepo;
import com.jsfspring.kerdoiv.service.KerdoivService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author zsombor2
 */
@Service
@Transactional
public class KerdoivServiceImpl implements KerdoivService {
    
    @Autowired
    private KerdoivRepo kerdoivRepo;

    @Override
    public List<KerdoivDto> getAllKerdoiv() {
        List<Kerdoiv> kerdoivLista = kerdoivRepo.findAll();
        List<KerdoivDto> kerdoivDtoLista = new ArrayList<>();
        for(Kerdoiv kerdoiv : kerdoivLista){
            KerdoivDto dto = convertKerdoivToDto(kerdoiv);
            kerdoivDtoLista.add(dto);
        }
        return kerdoivDtoLista;
    }

    
    @Override
    public KerdoivDto saveKerdoiv(KerdoivDto kerdoivDto){

        Kerdoiv kerdoiv = convertDtoToKerdoiv(kerdoivDto);
        Kerdoiv k = kerdoivRepo.save(kerdoiv);
        KerdoivDto dto = convertKerdoivToDto(k);
        return dto;
    }

    @Override
    public void deleteKerdoiv(KerdoivDto kerdoivDto) {
        Kerdoiv kerdoiv = convertDtoToKerdoiv(kerdoivDto);
        kerdoivRepo.delete(kerdoiv);
    }
    
    @Override
    public KerdoivDto convertKerdoivToDto(Kerdoiv kerdoiv){
        KerdoivDto dto = new KerdoivDto();
        dto.setId(kerdoiv.getId());
        dto.setTitle(kerdoiv.getTitle());
        List<KerdesDto> kerdesek = new ArrayList<>();
        for(Kerdes kerdes : kerdoiv.getKerdesek()){
            KerdesDto kerdesDto = convertKerdesToDto(kerdes);
            kerdesDto.setKerdoiv(dto);
            kerdesek.add(kerdesDto);
        }
        
        dto.setKerdesek(kerdesek);
        return dto;
    }
    
    @Override
    public Kerdoiv convertDtoToKerdoiv(KerdoivDto kerdoivDto){
        Kerdoiv kerdoiv = new Kerdoiv();
        kerdoiv.setId(kerdoivDto.getId());
        kerdoiv.setTitle(kerdoivDto.getTitle());
        List<Kerdes> kerdesek = new ArrayList<>();
        for(KerdesDto kerdesDto : kerdoivDto.getKerdesek()){
            Kerdes kerdes = convertDtoToKerdes(kerdesDto);
            kerdes.setKerdoiv(kerdoiv);
            kerdesek.add(kerdes);
        }
        
        kerdoiv.setKerdesek(kerdesek);
        
        return kerdoiv;
    }
    
    
    @Override
    public KerdesDto convertKerdesToDto(Kerdes kerdes){
        KerdesDto dto = new KerdesDto();
        dto.setId(kerdes.getId());
        dto.setKerdesSzoveg(kerdes.getKerdesSzoveg());
        return dto;
    }
    
    @Override
    public Kerdes convertDtoToKerdes(KerdesDto kerdesDto){
        Kerdes kerdes = new Kerdes();
        kerdes.setId(kerdesDto.getId());
        kerdes.setKerdesSzoveg(kerdesDto.getKerdesSzoveg());
        return kerdes;
    }
      
}

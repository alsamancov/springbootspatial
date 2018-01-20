package com.tuft.springbootspatial.service;

import com.tuft.springbootspatial.entity.RoughData;
import com.tuft.springbootspatial.repository.RoughDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoughDataService {

    @Autowired
    RoughDataRepository roughDataRepository;

    public void save(RoughData roughData){
        roughDataRepository.save(roughData);
    }
}

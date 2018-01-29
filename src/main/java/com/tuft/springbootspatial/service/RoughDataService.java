package com.tuft.springbootspatial.service;

import com.tuft.springbootspatial.entity.RoughData;
import com.tuft.springbootspatial.repository.RoughDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoughDataService {

    @Autowired
    RoughDataRepository roughDataRepository;

    public void save(RoughData roughData){
        roughDataRepository.save(roughData);
    }

    public List<RoughData> getAll(){
        return roughDataRepository.findAll();
    }
}

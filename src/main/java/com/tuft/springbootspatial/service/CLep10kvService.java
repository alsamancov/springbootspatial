package com.tuft.springbootspatial.service;

import com.tuft.springbootspatial.entity.CLep10kv;
import com.tuft.springbootspatial.repository.CLep10kvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CLep10kvService {

    @Autowired
    CLep10kvRepository cLep10kvRepository;



    public List<CLep10kv> getAllByRajon(String rajon){
        return (List<CLep10kv>) cLep10kvRepository.findByRajon(rajon);
    }

    public List<CLep10kv> getAll() {
        return  cLep10kvRepository.findAll();
    }
}

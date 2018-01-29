package com.tuft.springbootspatial.controller;

import com.tuft.springbootspatial.entity.CLep10kv;
import com.tuft.springbootspatial.entity.ImportException;
import com.tuft.springbootspatial.service.CLep10kvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CLep10kvController {


    @Autowired
    CLep10kvService cLep10kvService;



    @GetMapping(value = "/clep10kv/{rajon}")
    public ResponseEntity<List<CLep10kv>> getCLep10kvByRajon(@PathVariable("rajon")String rajon){
        List<CLep10kv> cLep10kvList = cLep10kvService.getAllByRajon(rajon);
        if(cLep10kvList.isEmpty()){
            throw new ImportException("There's no lines in this district");
        }
        return new ResponseEntity<>(cLep10kvList, HttpStatus.OK);

    }

    @GetMapping(value = "/clep10kv/all")
    public ResponseEntity<List<CLep10kv>> getAllLines(){
        List<CLep10kv> linesList;
        linesList = cLep10kvService.getAll();
        return new ResponseEntity<>(linesList, HttpStatus.OK);
    }
}

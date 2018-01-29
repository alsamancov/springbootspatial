package com.tuft.springbootspatial.controller;

import com.tuft.springbootspatial.entity.RoughData;
import com.tuft.springbootspatial.service.RoughDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RoughDataController {

    private final RoughDataService roughDataService;

    @Autowired
    public RoughDataController(RoughDataService roughDataService) {
        this.roughDataService = roughDataService;
    }

    @GetMapping(value = "/roughdata/all")
    public ResponseEntity<List<RoughData>> getAllProblems(){
        ArrayList<RoughData> roughDataArrayList;
        roughDataArrayList = (ArrayList<RoughData>) roughDataService.getAll();
        return new ResponseEntity<>(roughDataArrayList, HttpStatus.OK);
    }
}

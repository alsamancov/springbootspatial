package com.tuft.springbootspatial.controller;


import com.tuft.springbootspatial.entity.RoughData;
import com.tuft.springbootspatial.service.RoughDataService;
import com.tuft.springbootspatial.service.StorageService;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.operation.TransformException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ImportController {


    private final StorageService storageService;




    @Autowired
    public ImportController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/api/upload")
    public ResponseEntity<?> singleFileUpload(@RequestParam("file") MultipartFile file) throws FactoryException, TransformException {
        if(file.isEmpty()){
            return new ResponseEntity("please select a file!", HttpStatus.OK);
        }

        try{
            storageService.store(file);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Successfully uploaded - " + file.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/api/uploadStatus")
    public String uploadStatus(){
        return "uploadStatus";
    }



}

package com.tuft.springbootspatial.controller;


import com.tuft.springbootspatial.service.StorageService;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.operation.TransformException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class LoadPointsController {


    private final StorageService storageService;

    @Autowired
    public LoadPointsController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/datapoints/upload")
    public ResponseEntity<?> txtFileUpload(@RequestParam("file") MultipartFile file) throws  FactoryException, TransformException {

        if(file.isEmpty()){
            return new ResponseEntity("please select a file!", HttpStatus.OK);
        }

        try {
            storageService.store(file);
        } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Successfully uploaded - " + file.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);
    }



}

package com.tuft.springbootspatial.controller;


import com.tuft.springbootspatial.service.StorageService;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.operation.TransformException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@RestController
public class LoadSubstationsController {


    private final StorageService storageService;

    @Autowired
    public LoadSubstationsController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/substations/upload")
    public ResponseEntity<?> substationLoad(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws FactoryException, TransformException {

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
}

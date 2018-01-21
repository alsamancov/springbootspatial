package com.tuft.springbootspatial.controller;

import com.tuft.springbootspatial.service.LoadPointsService;
import com.tuft.springbootspatial.service.StorageService;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.operation.TransformException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/datapoints")
public class LoadPointsController {

    @Autowired
    StorageService storageService;


    @PostMapping("/upload")
    public String txtFileUpload(@RequestParam("upfile") MultipartFile file, RedirectAttributes redirectAttributes) throws  FactoryException, TransformException {
        return storageService.store(file, redirectAttributes);
    }

    @GetMapping("uploadStatus")
    public String uploadStatus(){
        return "uploadStatus";
    }

}

package com.tuft.springbootspatial.controller;


import com.tuft.springbootspatial.entity.UserUuid;
import com.tuft.springbootspatial.service.DatafileService;
import com.tuft.springbootspatial.service.StorageService;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.operation.TransformException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
public class ImportController {

    @Autowired
    StorageService storageService;

    @GetMapping("/")
    public String index(){
        return "upload";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("upfile") MultipartFile file, RedirectAttributes redirectAttributes) throws FactoryException, TransformException {


        return storageService.store(file, redirectAttributes);
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus(){
        return "uploadStatus";
    }

}

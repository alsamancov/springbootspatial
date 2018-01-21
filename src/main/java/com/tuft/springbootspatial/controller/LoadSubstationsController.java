package com.tuft.springbootspatial.controller;


import com.tuft.springbootspatial.service.StorageService;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.operation.TransformException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/substations")
public class LoadSubstationsController {

    @Autowired
    StorageService storageService;


    @PostMapping("/upload")
    public String substationLoad(@RequestParam("upfile") MultipartFile file, RedirectAttributes redirectAttributes) throws FactoryException, TransformException {
        return storageService.store(file, redirectAttributes);

    }
}

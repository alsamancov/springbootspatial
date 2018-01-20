package com.tuft.springbootspatial.controller;

import com.tuft.springbootspatial.service.AbonDataImportService;
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
@RequestMapping("/abondata")
public class AbonPointsController {

    @Autowired
    AbonDataImportService abonDataImportService;


    @PostMapping("/upload")
    public String txtFileUpload(@RequestParam("upfile") MultipartFile file, RedirectAttributes redirectAttributes){

        if(file.isEmpty()){
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try{
            byte[] bytes = file.getBytes();
            Path path = Paths.get(file.getOriginalFilename());
            Files.write(path, bytes);
            abonDataImportService.loadData(path);
            redirectAttributes.addFlashAttribute("message", "You successfully upload '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("uploadStatus")
    public String uploadStatus(){
        return "uploadStatus";
    }

}

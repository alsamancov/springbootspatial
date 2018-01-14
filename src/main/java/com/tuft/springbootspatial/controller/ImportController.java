package com.tuft.springbootspatial.controller;


import com.tuft.springbootspatial.entity.UserUuid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Controller
public class ImportController {

    @PostMapping("/upload")
    public UserUuid singleFileUpload(@RequestParam("upfile") MultipartFile file){
        UUID uuid = UUID.randomUUID();

        return null;
    }
}

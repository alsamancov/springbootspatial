package com.tuft.springbootspatial.service;

import org.opengis.referencing.FactoryException;
import org.opengis.referencing.operation.TransformException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class StorageService {

    @Autowired
    DatafileService datafileService;

    @Autowired
    LoadPointsService loadPointsService;

    @Autowired
    LoadSubstationsService loadSubstationsService;



    public void store(MultipartFile file) throws FactoryException, TransformException {
        UUID uuid = UUID.randomUUID();

//        if(file.isEmpty()){
//            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
//            return "redirect:uploadStatus";
//        }



        Map<String, DataLoadService> serviceMap = new HashMap<>();
        serviceMap.put(".dat", datafileService);
        serviceMap.put(".txt", loadPointsService);
        serviceMap.put(".dm3", loadSubstationsService);

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(file.getOriginalFilename());
            Files.write(path, bytes);

            String fileStr = String.valueOf(path);
            String keyWord = fileStr.substring(fileStr.length() - 4, fileStr.length());
            for(Map.Entry<String, DataLoadService> entry : serviceMap.entrySet()) {
                if(keyWord.equals(entry.getKey())) {
                    entry.getValue().loadData(path, uuid);
                }
            }
            //redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
        } catch (IOException e){
            e.printStackTrace();
        }

       // return "redirect:/uploadStatus";

    }
}

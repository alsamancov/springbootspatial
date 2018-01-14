package com.tuft.springbootspatial.service;

import com.tuft.springbootspatial.entity.*;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

@Component
public class DatafileService {
    public UserUuid loadData(Path path, UUID uuid) throws IOException {
        UserUuid userUuid = new UserUuid();
        File file = new File(path.toString());
        if(file == null){
            throw new ImportException("DAT-file is empty");
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<SurveyPoint> surveyPoints = new ArrayList<>();
        int counter = 0;
        try {
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                if(line.trim().length() > 0){
                    String tokens[] = line.split("\\,");

                    double latitude = Double.parseDouble(tokens[2]);
                    double longitude = Double.parseDouble(tokens[1]);
                    String description = tokens[4];
                    if(description.contains("W")){
                        description = description.toLowerCase();
                    }
                    String prims[] = description.split("w");
                    int code = Integer.parseInt(prims[0]);


                    Map<Integer, GISEntity> entityMap = new HashMap<>();

                    entityMap.put(141, new PrjOprTower());
                    entityMap.put(142, new PrjOprLeg());
                    entityMap.put(241, new KoeOprTower());
                    entityMap.put(242, new KoeOprLeg());
                    entityMap.put(341, new AbonOprTower());
                    entityMap.put(342, new AbonOprLeg());
                    entityMap.put(111, new PrjSubstation());
                    entityMap.put(112, new KoeSubstation());
                    entityMap.put(113, new AbonSubstation());

                    String name = prims[1];
                    String semantic = prims[3];

                    for(Map.Entry<Integer, GISEntity> entry : entityMap.entrySet()){
                        if(code == entry.getKey()){

                        }
                    }

                }
                counter++;
            }

        } finally {
            reader.close();
        }
        return userUuid;
    }
}

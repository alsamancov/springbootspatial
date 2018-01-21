package com.tuft.springbootspatial.service;

import com.tuft.springbootspatial.entity.ImportException;
import com.tuft.springbootspatial.entity.TextDataKeeper;
import com.tuft.springbootspatial.entity.UserUuid;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.operation.TransformException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@Service
public class LoadPointsService extends DataLoadService {

    @Autowired
    ReadFileService readFileService;


    @Override
    public UserUuid loadData(Path path, UUID uuid) throws IOException, FactoryException, TransformException {
        UserUuid userUuid = new UserUuid();
        File file = new File(path.toString());
        if(file == null){
            throw new ImportException("TXT-file is empty");
        }

        Map<Integer, EntityService> entityMap = new HashMap<>();
        entityMap.put(41, new PrjTowerService());
        entityMap.put(42, new PrjTowerLegService());
        entityMap.put(43, new KoeTowerService());
        entityMap.put(44, new KoeTowerLegService());
        entityMap.put(45, new AbonTowerService());
        entityMap.put(46, new AbonTowerLegService());
        entityMap.put(51, new Tower04Service());
        entityMap.put(52, new Tower04LegService());

        List<String> lines = new ArrayList<String>();

        try {
            lines = readFileService.getListFromFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            for(int i = 0; i < lines.size(); i++){
                String line = lines.get(i);
                if(line.trim().length() > 0){
                    if(line.startsWith("X")){
                        continue;
                    } else {
                        String tokens[] = line.split("\\t");

                        double latitude = Double.parseDouble(tokens[1]);
                        double longitude = Double.parseDouble(tokens[0]);
                        int code = Integer.parseInt(tokens[5]);
                        String text = tokens[2];
                        String silrada = tokens[3];
                        String rajon = tokens[4];

                        TextDataKeeper keeper = new TextDataKeeper(text, silrada, rajon, latitude, longitude);
                        for(Map.Entry<Integer, EntityService> entry : entityMap.entrySet()){
                            if(code == entry.getKey()){
                                entry.getValue().save(keeper);
                            }
                        }
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return userUuid;
    }
}

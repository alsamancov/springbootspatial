package com.tuft.springbootspatial.service;

import com.tuft.springbootspatial.entity.ImportException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@Component
public class AbonDataImportService {
    public void loadData(Path path) {
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
    }
}

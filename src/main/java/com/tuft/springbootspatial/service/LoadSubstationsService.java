package com.tuft.springbootspatial.service;

import com.tuft.springbootspatial.entity.ImportException;
import com.tuft.springbootspatial.entity.TextDataKeeper;
import com.tuft.springbootspatial.entity.UserUuid;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.operation.TransformException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LoadSubstationsService extends DataLoadService {

    @Autowired
    ReadFileService readFileService;

    @Override
    public UserUuid loadData(Path path, UUID uuid) throws IOException, FactoryException, TransformException {
        UserUuid userUuid = new UserUuid();
        File file = new File(path.toString());
        if(file == null){
            throw new ImportException("DM3-file is empty");
        }

        List<String> lines = new ArrayList<>();

        try {
            lines = readFileService.getListFromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<TextDataKeeper> keepers = new ArrayList<>();

        try{
            for(int i = 0; i < lines.size(); i++){
                String line = lines.get(i);
                if(line.trim().length() > 0){
                    String[] tokens = line.split("\\t");
                    double latitude = Double.parseDouble(tokens[1]);
                    double longitude = Double.parseDouble(tokens[0]);
                    String text = tokens[2];
                    String silrada = tokens[3];
                    String rajon = tokens[4];

                    TextDataKeeper keeper = new TextDataKeeper(text, silrada, rajon, latitude, longitude);
                    keepers.add(keeper);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}

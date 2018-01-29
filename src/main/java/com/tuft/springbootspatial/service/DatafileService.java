package com.tuft.springbootspatial.service;

import com.tuft.springbootspatial.entity.*;
import com.vividsolutions.jts.geom.Point;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.operation.TransformException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

@Component
public class DatafileService extends DataLoadService {

    @Autowired
    CoordinateTransformService coordinateTransformService;

    @Autowired
    HttpURLService httpURLService;

    @Autowired
    KmlImportService kmlImportService;

    @Autowired
    TxtImportService txtImportService;

    @Autowired
    RoughDataService roughDataService;

    @Override
    public UserUuid loadData(Path path, UUID uuid) throws IOException, FactoryException, TransformException {
        UserUuid userUuid = new UserUuid();
        File file = new File(path.toString());
        if(file == null){
            throw new ImportException("DAT-file is empty");
        }

        String fileStr = String.valueOf(file.getAbsoluteFile());
        String newPath = fileStr.substring(0, fileStr.length() - 4);

        String[] numOrders = newPath.split("\\\\");
        String numOrder = numOrders[numOrders.length - 2];


        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<SurveyPoint> surveyPoints = new ArrayList<>();
        int counter = 0;
        int codes = 0;
        String justRajon = null;
        try {
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                if(line.trim().length() > 0){
                    String tokens[] = line.split("\\,");

                    double latitude = Double.parseDouble(tokens[2]);
                    double longitude = Double.parseDouble(tokens[1]);
                    String description = tokens[4].replace("w", "W");
                    String descriptionArray[] = description.split("W");
                    int code = Integer.parseInt(descriptionArray[0]);


                    Map<Integer, CodeEntity> entityMap = new HashMap<>();

                    entityMap.put(111, new KTPSubstation());
                    entityMap.put(112, new ZTPSubstation());
                    entityMap.put(113, new RPSubstation());
                    entityMap.put(222, new CodeTower10());
                    entityMap.put(223, new CodeTower10Ukos());
                    entityMap.put(224, new CablePoint10());
                    entityMap.put(51, new CodeTower04());
                    entityMap.put(52, new CodeTower04Ukos());
                    entityMap.put(53, new CablePoint04());
                    entityMap.put(77, new SituationPoint());
                    entityMap.put(88, new PStation());

                    String name = null;

                    for(Map.Entry<Integer, CodeEntity> entry : entityMap.entrySet()){
                        if(code == entry.getKey()){
                            code = entry.getValue().getCode(descriptionArray);
                            name = entry.getValue().getText(descriptionArray);
                            if(code == 222 || code == 223){
                                codes++;
                            }
                            if(code == 51 || code == 52){
                                codes++;
                            }
                        }
                    }

                    Point point = coordinateTransformService.getPoint(longitude, latitude);
                    point.setSRID(4326);


                    String silrada;
                    String rajon;

                    try {
                        //silrada = httpURLService.getSilrada();

                        //rajon = httpURLService.getRajon();
                        silrada = "";
                        rajon = "";
                        if(justRajon == null){
                            justRajon = rajon;
                        }
                    }catch (Exception e){
                        silrada = "";
                        rajon = "";
                    }

                    surveyPoints.add(counter, new SurveyPoint(point.getX(), point.getY(), name, silrada, rajon, code, tokens[4]));

                    Calendar calendar = Calendar.getInstance();
                    Date currentDate = calendar.getTime();

                    roughDataService.save(new RoughData(counter, uuid, numOrder, description, point, currentDate));

                }
                counter++;
            }

        } finally {
            reader.close();
        }

        kmlImportService.writeKmlFile(file, surveyPoints);

        txtImportService.writeTxtFile(file, surveyPoints);


        return userUuid;
    }

}

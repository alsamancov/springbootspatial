package com.tuft.springbootspatial.service;

import com.tuft.springbootspatial.entity.SurveyPoint;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@Component
public class KmlImportService {
    public void writeKmlFile(File file, List<SurveyPoint> list) {
        final Kml kml = new Kml();

        String fileStr = String.valueOf(file.getAbsoluteFile());
        String newPath = fileStr.substring(0, fileStr.length() - 4);

        Document document = kml.createAndSetDocument().withName(newPath);
        for(SurveyPoint surveyPoint : list) {
            document.createAndAddPlacemark()
                    .withName(newPath)
                    .withDescription(surveyPoint.getDescription())
                    .withOpen(Boolean.TRUE)
                    .createAndSetPoint()
                    .addToCoordinates(surveyPoint.getX(), surveyPoint.getY());
        }
        kml.setFeature(document);
        String kmlPath = fileStr.substring(0, fileStr.length() - 4) + ".kml";
        try {
            kml.marshal(new File(kmlPath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

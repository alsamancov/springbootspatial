package com.tuft.springbootspatial.service;

import com.tuft.springbootspatial.entity.SurveyPoint;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Component
public class TxtImportService {
    public void writeTxtFile(File file, List<SurveyPoint> surveyPointList){
        String fileStr = file.getAbsolutePath();
        String newPath = fileStr.substring(0, fileStr.length() - 4) + ".txt";

        try {
            PrintWriter out = new PrintWriter(newPath, "UTF-8");

            try {
                out.println("X,Y,TEXT,SILRADA,RAJON,CODE,PRIM");
                for(SurveyPoint surveyPoint : surveyPointList){
                    out.println(surveyPoint.toString());
                }
            } finally {
                out.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

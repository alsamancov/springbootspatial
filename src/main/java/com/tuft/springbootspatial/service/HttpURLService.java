package com.tuft.springbootspatial.service;

import com.vividsolutions.jts.geom.Point;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class HttpURLService {

    private final String USER_AGENT = "Mozzila/5.0";
    private double longitude;
    private double latitude;
    private String responceString;
    private String silrada;
    private String rajon;

    public HttpURLService() {
    }

    public HttpURLService(Point point) throws IOException {
        this.longitude = point.getX();
        this.latitude = point.getY();
        this.responceString = this.getResponceString();
    }

    public String getSilrada() throws IOException {
        String[] firstArray = responceString.split("       ");
        for(String str : firstArray){
            if(str.contains("РЎРѓРЎвЂ“Р В»РЎРЉРЎРѓРЎРЉР С”Р В° РЎР‚Р В°Р Т‘Р В°") || str.contains("РЎРѓР ВµР В»Р С‘РЎвЂ°Р Р…Р В° РЎР‚Р В°Р Т‘Р В°") || str.contains("Р СРЎвЂ“РЎРѓРЎРЉР С”Р В° РЎР‚Р В°Р Т‘Р В°")){
                String[] secondArray = str.split(" ");
                silrada = secondArray[0];
            }
        }
        return silrada;
    }

    public String getRajon() {
        String[] firstArray = responceString.split("       ");
        for(String str : firstArray){
            if(str.contains("РЎР‚Р В°Р в„–Р С•Р Р…") || str.contains("Р СРЎвЂ“РЎРѓРЎРЉР С”Р В° РЎР‚Р В°Р Т‘Р В°")){
                String[] secondArray = str.split(" ");
                rajon = secondArray[0];
            }
        }
        return rajon;
    }



    public String getResponceString() throws IOException {
        String url = "http://atu.minregion.gov.ua/api/format/list_ato_template/ato.ato_full_view/wkb_geometry&&&&'POINT(" + longitude + "%20" + latitude + ")'::geometry%20order%20by%20level/0/null/10";

        URL obj = new URL(url);

        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", USER_AGENT);

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String inputLine;
        StringBuffer response = new StringBuffer();
        while((inputLine = in.readLine()) != null){
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}

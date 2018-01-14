package com.tuft.springbootspatial.entity;

public class SurveyPoint {
    private long id;
    private double X;
    private double Y;
    private double Z;
    private String text;
    private String silrada;
    private String rajon;
    private int code;
    private String description;

    public SurveyPoint(){
    }

    public SurveyPoint(long id, double x, double y, String text, String silrada, String rajon, int code, String description) {
        this.id = id;
        X = x;
        Y = y;
        this.text = text;
        this.silrada = silrada;
        this.rajon = rajon;
        this.code = code;
        this.description = description;
    }

    public SurveyPoint(long id, double x, double y, double z, String text, String silrada, String rajon, int code, String description) {
        this.id = id;
        X = x;
        Y = y;
        Z = z;
        this.text = text;
        this.silrada = silrada;
        this.rajon = rajon;
        this.code = code;
        this.description = description;
    }

    public SurveyPoint(double x, double y, String text, String silrada, String rajon, int code, String description) {
        X = x;
        Y = y;
        this.text = text;
        this.silrada = silrada;
        this.rajon = rajon;
        this.code = code;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    public double getZ() {
        return Z;
    }

    public void setZ(double z) {
        Z = z;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSilrada() {
        return silrada;
    }

    public void setSilrada(String silrada) {
        this.silrada = silrada;
    }

    public String getRajon() {
        return rajon;
    }

    public void setRajon(String rajon) {
        this.rajon = rajon;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  X +
                "," + Y +
                "," + text +
                "," + silrada +
                "," + rajon +
                "," + code +
                "," + description;
    }
}

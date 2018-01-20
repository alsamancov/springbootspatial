package com.tuft.springbootspatial.entity;

public class TextDataKeeper extends GISObject {
    private double latitude;
    private double longitude;

    public TextDataKeeper() {
    }

    public TextDataKeeper(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public TextDataKeeper(String text, String silrada, String rajon, double latitude, double longitude) {
        super(text, silrada, rajon);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "TextDataKeeper{" + super.toString() +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

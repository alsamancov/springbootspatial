package com.tuft.springbootspatial.entity;

import com.vividsolutions.jts.geom.Point;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class GISPoint extends GISObject{
    @Column(columnDefinition = "geometry(Point,4326)")
    private Point point;

    public GISPoint() {
    }

    public GISPoint(Point point) {
        this.point = point;
    }

    public GISPoint(String text, String silrada, String rajon, Point point) {
        super(text, silrada, rajon);
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}

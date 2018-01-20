package com.tuft.springbootspatial.entity;

import com.vividsolutions.jts.geom.LineString;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class GISLine extends GISObject {
    @Column(columnDefinition = "geometry(LineString,4326)")
    private LineString lineString;

    public GISLine() {
    }

    public GISLine(LineString lineString) {
        super();
        this.lineString = lineString;
    }

    public GISLine(String text, String silrada, String rajon, LineString lineString) {
        super(text, silrada, rajon);
        this.lineString = lineString;
    }

    public LineString getLineString() {
        return lineString;
    }

    public void setLineString(LineString lineString) {
        this.lineString = lineString;
    }
}

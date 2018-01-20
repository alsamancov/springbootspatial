package com.tuft.springbootspatial.entity;

import com.vividsolutions.jts.geom.LineString;

import javax.persistence.*;

@Entity
@Table(name = "p_LEP_10kV")
public class PLep10kv extends GISLine {

    @Column(name = "LENGTH_")
    private Double length;
    @Column(name = "flag")
    private int flag;

    public PLep10kv() {
    }

    public PLep10kv(Double length, int flag) {
        this.length = length;
        this.flag = flag;
    }

    public PLep10kv(LineString lineString, Double length, int flag) {
        super(lineString);
        this.length = length;
        this.flag = flag;
    }

    public PLep10kv(String text, String silrada, String rajon, LineString lineString, Double length, int flag) {
        super(text, silrada, rajon, lineString);
        this.length = length;
        this.flag = flag;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}

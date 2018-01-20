package com.tuft.springbootspatial.entity;

import com.vividsolutions.jts.geom.Point;

import javax.persistence.*;

@Entity
@Table(name = "p_LEP_10kV_nomera_opor")
public class PLep10kvNomeraOpor extends GISPoint {

    @Column(name = "LENGTH_")
    private Double length;
    @Column(name = "FLAG")
    private int flag;


    public PLep10kvNomeraOpor() {
    }

    public PLep10kvNomeraOpor(Double length, int flag) {
        this.length = length;
        this.flag = flag;
    }

    public PLep10kvNomeraOpor(Point point, Double length, int flag) {
        super(point);
        this.length = length;
        this.flag = flag;
    }

    public PLep10kvNomeraOpor(String text, String silrada, String rajon, Point point, Double length, int flag) {
        super(text, silrada, rajon, point);
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

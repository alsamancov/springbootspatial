package com.tuft.springbootspatial.entity;

import com.vividsolutions.jts.geom.Point;

import javax.persistence.*;

@Entity
@Table(name = "p_LEP_10kV_name")
public class PLep10kvName extends GISPoint {

    @Column(name = "FLAG")
    private int flag;


    public PLep10kvName() {
    }


    public PLep10kvName(int flag) {
        this.flag = flag;
    }

    public PLep10kvName(Point point, int flag) {
        super(point);
        this.flag = flag;
    }

    public PLep10kvName(String text, String silrada, String rajon, Point point, int flag) {
        super(text, silrada, rajon, point);
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}

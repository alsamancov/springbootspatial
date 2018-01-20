package com.tuft.springbootspatial.entity;

import com.vividsolutions.jts.geom.Point;

import javax.persistence.*;

@Entity
@Table(name = "p_TP_name")
public class PTpName extends GISPoint {

    @Column(name = "flag")
    private int flag;

    public PTpName() {
    }

    public PTpName(int flag) {
        this.flag = flag;
    }

    public PTpName(Point point, int flag) {
        super(point);
        this.flag = flag;
    }

    public PTpName(String text, String silrada, String rajon, Point point, int flag) {
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

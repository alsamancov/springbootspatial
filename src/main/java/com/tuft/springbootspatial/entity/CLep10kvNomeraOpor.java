package com.tuft.springbootspatial.entity;

import com.vividsolutions.jts.geom.Point;

import javax.persistence.*;

@Entity
@Table(name = "c_LEP_10kV_nomera_opor")
public class CLep10kvNomeraOpor extends GISPoint {

    @Column(name = "flag")
    private int flag;

    public CLep10kvNomeraOpor() {
    }

    public CLep10kvNomeraOpor(int flag) {
        this.flag = flag;
    }

    public CLep10kvNomeraOpor(Point point, int flag) {
        super(point);
        this.flag = flag;
    }

    public CLep10kvNomeraOpor(String text, String silrada, String rajon, Point point, int flag) {
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

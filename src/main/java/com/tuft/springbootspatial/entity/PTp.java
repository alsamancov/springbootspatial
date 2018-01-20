package com.tuft.springbootspatial.entity;

import com.vividsolutions.jts.geom.LineString;

import javax.persistence.*;

@Entity
@Table(name = "p_TP")
public class PTp extends GISLine {

    @Column(name = "flag")
    private int flag;

    public PTp() {
    }

    public PTp(int flag) {
        this.flag = flag;
    }

    public PTp(LineString lineString, int flag) {
        super(lineString);
        this.flag = flag;
    }

    public PTp(String text, String silrada, String rajon, LineString lineString, int flag) {
        super(text, silrada, rajon, lineString);
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}

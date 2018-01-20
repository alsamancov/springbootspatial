package com.tuft.springbootspatial.entity;

import com.vividsolutions.jts.geom.LineString;

import javax.persistence.*;

@Entity
@Table(name = "p_LEP_10kV_opory")
public class PLep10kvOpory extends GISLine{

    @Column(name = "FLAG")
    private int flag;

    public PLep10kvOpory() {
    }

    public PLep10kvOpory(int flag) {
        this.flag = flag;
    }

    public PLep10kvOpory(LineString lineString, int flag) {
        super(lineString);
        this.flag = flag;
    }

    public PLep10kvOpory(String text, String silrada, String rajon, LineString lineString, int flag) {
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

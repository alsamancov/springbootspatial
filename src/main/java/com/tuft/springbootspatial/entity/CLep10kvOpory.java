package com.tuft.springbootspatial.entity;

import com.vividsolutions.jts.geom.LineString;

import javax.persistence.*;

@Entity
@Table(name = "c_LEP_10kV_opory")
public class CLep10kvOpory extends GISLine {

    @Column(name = "flag")
    private int flag;

    public CLep10kvOpory() {
    }

    public CLep10kvOpory(int flag) {
        this.flag = flag;
    }

    public CLep10kvOpory(LineString lineString, int flag) {
        super(lineString);
        this.flag = flag;
    }

    public CLep10kvOpory(String text, String silrada, String rajon, LineString lineString, int flag) {
        super(text, silrada, rajon, lineString);
        this.flag = flag;
    }
}

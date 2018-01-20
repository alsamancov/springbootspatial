package com.tuft.springbootspatial.entity;

import com.vividsolutions.jts.geom.LineString;

import javax.persistence.*;

@Entity
@Table(name = "c_LEP_10kV")
public class CLep10kv extends GISLine {

    @Column(name = "LENGTH_")
    private Double length;
    @Column(name = "flag")
    private int flag;


    public CLep10kv() {
    }

    public CLep10kv(Double length, int flag) {
        this.length = length;
        this.flag = flag;
    }

    public CLep10kv(LineString lineString, Double length, int flag) {
        super(lineString);
        this.length = length;
        this.flag = flag;
    }

    public CLep10kv(String text, String silrada, String rajon, LineString lineString, Double length, int flag) {
        super(text, silrada, rajon, lineString);
        this.length = length;
        this.flag = flag;
    }
}

package com.tuft.springbootspatial.entity;

import com.vividsolutions.jts.geom.LineString;

import javax.persistence.*;

@Entity
@Table(name = "c_LEP_10kV_opory")
public class CLep10kvOpory {
    @Id
    @GeneratedValue
    private Long gid;
    @Column(name = "SILRADA")
    private String silrada;
    @Column(name = "RAJON")
    private String rajon;
    @Column(name = "geom", columnDefinition = "geometry(LineString,4326)")
    private LineString lineString;
    @Column(name = "text")
    private String text;
    @Column(name = "flag")
    private int flag;

    public CLep10kvOpory() {
    }

    public CLep10kvOpory(String silrada, String rajon, LineString lineString, String text, int flag) {
        this.silrada = silrada;
        this.rajon = rajon;
        this.lineString = lineString;
        this.text = text;
        this.flag = flag;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getSilrada() {
        return silrada;
    }

    public void setSilrada(String silrada) {
        this.silrada = silrada;
    }

    public String getRajon() {
        return rajon;
    }

    public void setRajon(String rajon) {
        this.rajon = rajon;
    }


    public LineString getLineString() {
        return lineString;
    }

    public void setLineString(LineString lineString) {
        this.lineString = lineString;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}

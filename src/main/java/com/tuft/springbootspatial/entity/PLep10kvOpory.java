package com.tuft.springbootspatial.entity;

import com.vividsolutions.jts.geom.LineString;

import javax.persistence.*;

@Entity
@Table(name = "p_LEP_10kV_opory")
public class PLep10kvOpory {
    @Id
    @GeneratedValue
    private Long gid;
    @Column(name = "TEXT")
    private String text;
    @Column(name = "SILRADA")
    private String silrada;
    @Column(name = "RAJON")
    private String rajon;
    @Column(name = "geom", columnDefinition = "geometry(LineString,4326)")
    private LineString lineString;
    @Column(name = "FLAG")
    private int flag;

    public PLep10kvOpory() {
    }

    public PLep10kvOpory(String text, String silrada, String rajon, LineString lineString, int flag) {
        this.text = text;
        this.silrada = silrada;
        this.rajon = rajon;
        this.lineString = lineString;
        this.flag = flag;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}

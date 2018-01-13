package com.tuft.springbootspatial.entity;

import com.vividsolutions.jts.geom.LineString;

import javax.persistence.*;

@Entity
@Table(name = "d_TP_name")
public class DTpName {
    @Id
    @GeneratedValue
    private Long gid;
    @Column(name = "TEXT")
    private String text;
    @Column(name = "SILRADA")
    private String silrada;
    @Column(name = "RAJON")
    private String rajon;
    @Column(name = "the_geom", columnDefinition = "geometry(LineString)")
    private LineString lineString;

    public DTpName() {
    }

    public DTpName(String text, String silrada, String rajon, LineString lineString) {
        this.text = text;
        this.silrada = silrada;
        this.rajon = rajon;
        this.lineString = lineString;
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
}

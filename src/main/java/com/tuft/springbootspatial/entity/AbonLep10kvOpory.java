package com.tuft.springbootspatial.entity;

import com.vividsolutions.jts.geom.LineString;

import javax.persistence.*;

@Entity
@Table(name = "abon_LEP_10kV_opory")
public class AbonLep10kvOpory {
    @Id
    @GeneratedValue
    private Long gid;
    @Column(name = "SILRADA")
    private String silrada;
    @Column(name = "RAJON")
    private String rajon;
    @Column(name = "LENGTH_")
    private Double length;
    @Column(name = "geom", columnDefinition = "geometry(LineString)")
    private LineString lineString;
    @Column(name = "text")
    private String text;

    public AbonLep10kvOpory() {
    }

    public AbonLep10kvOpory(String silrada, String rajon, Double length, LineString lineString, String text) {
        this.silrada = silrada;
        this.rajon = rajon;
        this.length = length;
        this.lineString = lineString;
        this.text = text;
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

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
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
}

package com.tuft.springbootspatial.entity;

import com.vividsolutions.jts.geom.LineString;

import javax.persistence.*;

@Entity
@Table(name = "d_TP")
public class DTp {
    @Id
    @GeneratedValue
    private Long gid;
    @Column(name = "SILRADA")
    private String silrada;
    @Column(name = "RAJON")
    private String rajon;
    @Column(name = "the_geom", columnDefinition = "geometry(LineString)")
    private LineString lineString;
    @Column(name = "text")
    private String text;

    public DTp() {
    }

    public DTp(String silrada, String rajon, LineString lineString, String text) {
        this.silrada = silrada;
        this.rajon = rajon;
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

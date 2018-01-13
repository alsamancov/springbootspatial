package com.tuft.springbootspatial.entity;

import com.vividsolutions.jts.geom.LineString;

import javax.persistence.*;

@Entity
@Table(name = "abon_TP")
public class AbonTp {
    @Id
    @GeneratedValue
    private Long gid;
    @Column(name = "SILRADA")
    private String silrada;
    @Column(name = "RAJON")
    private String rajon;
    @Column(name = "TEXT")
    private String text;
    @Column(name = "the_geom", columnDefinition = "geometry(LineString)")
    private LineString lineString;

    public AbonTp() {
    }

    public AbonTp(String silrada, String rajon, String text, LineString lineString) {
        this.silrada = silrada;
        this.rajon = rajon;
        this.text = text;
        this.lineString = lineString;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LineString getLineString() {
        return lineString;
    }

    public void setLineString(LineString lineString) {
        this.lineString = lineString;
    }
}

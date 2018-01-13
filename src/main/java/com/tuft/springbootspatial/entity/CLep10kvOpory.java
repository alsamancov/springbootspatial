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
    @Column(name = "LENGTH_")
    private Double length;
    @Column(name = "geom", columnDefinition = "geometry(LineString,4326)")
    private LineString lineString;


    public CLep10kvOpory() {
    }

    public CLep10kvOpory(String silrada, String rajon, Double length, LineString lineString) {
        this.silrada = silrada;
        this.rajon = rajon;
        this.length = length;
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
}

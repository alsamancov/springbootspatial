package com.tuft.springbootspatial.entity;

import com.vividsolutions.jts.geom.Point;

import javax.persistence.*;

@Entity
@Table(name = "c_LEP_10kV_name")
public class CLep10kvName {
    @Id
    @GeneratedValue
    private Long gid;
    @Column(name = "TEXT")
    private String text;
    @Column(name = "SILRADA")
    private String silrada;
    @Column(name = "RAJON")
    private String rajon;
    @Column(name = "the_geom", columnDefinition = "geometry(Point)")
    private Point point;
    @Column(name = "flag")
    private int flag;

    public CLep10kvName() {
    }

    public CLep10kvName(String text, String silrada, String rajon, Point point, int flag) {
        this.text = text;
        this.silrada = silrada;
        this.rajon = rajon;
        this.point = point;
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

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}

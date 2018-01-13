package com.tuft.springbootspatial.entity;

import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;

import javax.persistence.*;

@Entity
@Table(name = "c_LEP_10kV_nomera_opor")
public class CLep10kvNomeraOpor {
    @Id
    @GeneratedValue
    private Long gid;
    @Column(name = "TEXT")
    private String text;
    @Column(name = "SILRADA")
    private String silrada;
    @Column(name = "RAJON")
    private String rajon;
    @Column(name = "LENGTH_")
    private Double length;
    @Column(name = "geom", columnDefinition = "geometry(Point,4326)")
    private Point point;

}

package com.tuft.springbootspatial.entity;


import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

}

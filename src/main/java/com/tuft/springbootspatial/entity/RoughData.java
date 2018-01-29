package com.tuft.springbootspatial.entity;

import com.vividsolutions.jts.geom.Point;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "rough_data")
public class RoughData {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long gid;
    private int counter;
    private UUID uuid;
    private String task;
    private String description;
    @Column(columnDefinition = "geometry(Point,4326)")
    private Point geom;
    private Date date;

    public RoughData() {
    }

    public RoughData(int counter, UUID uuid, String task, String description, Point geom, Date date) {
        this.counter = counter;
        this.uuid = uuid;
        this.task = task;
        this.description = description;
        this.geom = geom;
        this.date = date;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Point getGeom() {
        return geom;
    }

    public void setGeom(Point geom) {
        this.geom = geom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
